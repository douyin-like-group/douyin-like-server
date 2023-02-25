package com.rocky.service.impl;

import com.rocky.bo.MessageBO;
import com.rocky.result.MessageEnum;
import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.mapper.FollowMapper;
import com.rocky.pojo.Follow;
import com.rocky.service.FollowService;
import com.rocky.service.UsersService;
import com.rocky.utils.JsonUtils;
import com.rocky.utils.RabbitMQConfig;
import com.rocky.vo.FriendUserVO;
import com.rocky.result.ResultVO;
import com.rocky.vo.UsersVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class FollowServiceImpl extends BaseInfoProperties implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UsersService usersService;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Override
    public ResultVO follow(long fromUID, long toUID) {
        // 先判断toUID有没有关注fromUID
        boolean hasBeenFollowed = isFollow(toUID, fromUID);

        // 尝试update数据库中的follow_status为1，并获取受影响行数
        int lines;
        if (hasBeenFollowed) {
            followMapper.updateFollow(toUID, fromUID, (byte) 1);
            lines = followMapper.updateFollow(fromUID, toUID, (byte) 1);
        } else {
            lines = followMapper.updateFollow(fromUID, toUID, (byte) 0);
        }

        if (lines == 0) { // 受影响行数为0，说明需insert关注记录到数据库中
            Follow follow = new Follow();
            follow.setFromId(fromUID);
            follow.setToId(toUID);
            follow.setFollowStatus((byte) 1);
            if (hasBeenFollowed) {
                follow.setIsFriend((byte) 1);
            } else {
                follow.setIsFriend((byte) 0);
            }
            follow.setCreateTime(new Date());

            followMapper.insert(follow);
        }
//todo
        // 系统消息：关注博主

        // MQ异步解耦

        //使用官方账户发送谁关注你了


        MessageBO messageBO = new MessageBO(1L,toUID,"有人关注你了！",(byte)0);
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_MSG,
                "sys.msg." + MessageEnum.FOLLOW_YOU.enValue,
                JsonUtils.objectToJson(messageBO));

        return ResultVO.ok(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResultVO unFollow(long fromUID, long toUID) {
        // 先判断toUID有没有关注fromUID
        boolean hasBeenFollowed = isFollow(toUID, fromUID);
        if (hasBeenFollowed) {
            followMapper.updateFollow(toUID, fromUID, (byte) 0);
        }

        followMapper.updateUnfollow(fromUID, toUID);

        return ResultVO.ok(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResultVO getFollowList(long uid) {
        List<Long> toIDList = followMapper.selectFollowListByUID(uid);

        List<UsersVO> userList = new ArrayList<UsersVO>();
        for (Long toID : toIDList) {
            userList.add(usersService.findById(uid, toID));
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("成功获取关注列表");
        resultVO.setData(userList);
        resultVO.setObjectName("user_list");

        return resultVO;
    }

    @Override
    public ResultVO getFollowerList(long uid) {
        List<Long> fromIDList = followMapper.selectFollowerListByUID(uid);

        List<UsersVO> userList = new ArrayList<UsersVO>();
        for (Long fromID : fromIDList) {
            userList.add(usersService.findById(uid, fromID));
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("成功获取粉丝列表");
        resultVO.setData(userList);
        resultVO.setObjectName("user_list");

        return resultVO;
    }

    @Override
    public ResultVO getFriendList(long uid) {
        List<Long> toIDList = followMapper.selectFriendListByUID(uid);

        List<FriendUserVO> userList = new ArrayList<FriendUserVO>();
        for (Long toID : toIDList) {
            UsersVO usersVO =  usersService.findById(uid, toID);
            FriendUserVO friendUserVO = new FriendUserVO(usersVO,"hello",0L);
            userList.add(friendUserVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("成功获取朋友列表");
        resultVO.setData(userList);
        resultVO.setObjectName("user_list");

        return resultVO;
    }

    @Override
    public long getFollowCount(long uid) {
        return followMapper.selectFollowCount(uid);
    }

    @Override
    public long getFollowerCount(long uid) {
        return followMapper.selectFollowerCount(uid);
    }

    @Override
    public boolean isFollow(long fromId, long toId) {
        Follow follow = new Follow();
        follow.setFromId(fromId);
        follow.setToId(toId);

        List<Follow> followList = followMapper.select(follow);
        if (followList.size() == 0) {
            return false;
        }

        Follow result = followList.get(0);
        return result.getFollowStatus() != (byte) 0;
    }




}

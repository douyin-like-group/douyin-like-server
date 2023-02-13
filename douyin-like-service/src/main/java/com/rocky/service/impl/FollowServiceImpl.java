package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FollowMapper;
import com.rocky.pojo.Favorite;
import com.rocky.pojo.Follow;
import com.rocky.service.FollowService;
import com.rocky.service.UsersService;
import com.rocky.vo.ResultVO;
import com.rocky.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class FollowServiceImpl extends BaseInfoProperties implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UsersService usersService;

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

        return new ResultVO(0, "关注成功", null, null);
    }

    @Override
    public ResultVO unFollow(long fromUID, long toUID) {
        // 先判断toUID有没有关注fromUID
        boolean hasBeenFollowed = isFollow(toUID, fromUID);
        if (hasBeenFollowed) {
            followMapper.updateFollow(toUID, fromUID, (byte) 0);
        }

        followMapper.updateUnfollow(fromUID, toUID);

        return new ResultVO(0, "取消关注成功", null, null);
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

        List<UsersVO> userList = new ArrayList<UsersVO>();
        for (Long toID : toIDList) {
            userList.add(usersService.findById(uid, toID));
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

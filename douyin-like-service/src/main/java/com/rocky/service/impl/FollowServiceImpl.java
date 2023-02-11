package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FollowMapper;
import com.rocky.pojo.Favorite;
import com.rocky.pojo.Follow;
import com.rocky.service.FollowService;
import com.rocky.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class FollowServiceImpl extends BaseInfoProperties implements FollowService {
    @Autowired
    private FollowMapper followMapper;

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

        System.out.println("lines = " + lines);
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
        return null;
    }

    @Override
    public ResultVO getFollowerList(long uid) {
        return null;
    }

    @Override
    public ResultVO getFriendList(long uid) {
        return null;
    }

    @Override
    public long getFollowCount(long uid) {
        return 0;
    }

    @Override
    public long getFollowerCount(long uid) {
        return 0;
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
    //todo

}

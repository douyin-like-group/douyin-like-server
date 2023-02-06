package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.service.FollowService;
import com.rocky.vo.ResultVO;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImpl extends BaseInfoProperties implements FollowService  {
    @Override
    public ResultVO follow(long fromUID, long toUID) {
        return null;
    }

    @Override
    public ResultVO unFollow(long fromUID, long toUID) {
        return null;
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
        return false;
    }
    //todo

}

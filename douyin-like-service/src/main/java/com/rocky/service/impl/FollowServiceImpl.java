package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FollowMapper;
import com.rocky.service.FollowService;
import com.rocky.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FollowServiceImpl extends BaseInfoProperties implements FollowService  {
    @Autowired
    private FollowMapper followMapper;

    @Transactional
    @Override
    public ResultVO follow(long fromUID, long toUID) {
        if (isFollow(fromUID, toUID)) {
            return new ResultVO(0, "重复关注", null, null);
        }





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
        return true;
    }
    //todo

}

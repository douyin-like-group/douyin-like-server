package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Follow;

public interface FollowMapper extends MyMapper<Follow> {
    /**
     * 以update方式使fromUserID关注toUserID
     * @param fromUserID
     * @param toUserID
     * @return 受影响的行数
     */
    int updateFollow(long fromUserID, long toUserID);

    int insertFollow(long fromUserID, long toUserID);

}
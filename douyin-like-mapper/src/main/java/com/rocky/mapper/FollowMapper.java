package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Follow;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper extends MyMapper<Follow> {
    /**
     * 以update方式使fromUserID关注toUserID
     * @param fromUserID
     * @param toUserID
     * @return 受影响的行数
     */
    int updateFollow(@Param("from_id") long fromUserID,
                     @Param("to_id") long toUserID,
                     @Param("is_friend") Byte isFriend);


}
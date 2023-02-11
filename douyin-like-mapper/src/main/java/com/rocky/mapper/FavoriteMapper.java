package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Favorite;
import org.apache.ibatis.annotations.Param;

public interface FavoriteMapper extends MyMapper<Favorite> {
    int updateLike(@Param("uid") long uid, @Param("vid") long vid);
    int updateUnlike(@Param("uid") long uid, @Param("vid") long vid);
}
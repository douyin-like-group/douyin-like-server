package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper extends MyMapper<Favorite> {
    int updateLike(@Param("uid") long uid, @Param("vid") long vid);
    int updateUnlike(@Param("uid") long uid, @Param("vid") long vid);
    List<Long> selectVIDByUID(@Param("uid") long uid);
    Long selectFavoriteCountByVID(@Param("vid") long vid);
    Favorite selectFavoriteByUIDAndVID(@Param("uid") long uid, @Param("vid") long vid);
}
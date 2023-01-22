package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Favorite;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMapper extends MyMapper<Favorite> {
}
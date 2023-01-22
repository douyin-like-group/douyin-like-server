package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper extends MyMapper<Video> {
}
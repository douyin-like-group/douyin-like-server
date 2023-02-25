package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;


public interface VideoMapper extends MyMapper<Video> {

    List<Video> selectVideoFeedByTime(Date endTime);

    Void updateFavoriteCounts(long videoID, Integer counts);


}
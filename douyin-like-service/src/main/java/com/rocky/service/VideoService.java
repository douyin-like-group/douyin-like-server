package com.rocky.service;

import com.rocky.bo.VideoBO;
import com.rocky.vo.VideoVO;

import java.util.Date;
import java.util.List;


public interface VideoService {
    // todo
    //zhu

    boolean createVideo(VideoBO videoBO);

    VideoVO getVideoVODetail(long sourceUserId, long vid);

    List<VideoVO> getAllVideoList(long sourceUserId, long targetUserId);

    List<VideoVO> findVideoFeed(long sourceUserId, Date endTime);

    Date findDateById(long videoId);

    long findUserIdByVideoId(long videoId);

    //public List<Video> getVideoFeedByTime(Date time);





}

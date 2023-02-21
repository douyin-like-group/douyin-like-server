package com.rocky.service;

import com.rocky.bo.VideoBO;
import com.rocky.vo.VideoVO;

import java.util.Date;
import java.util.List;


public interface VideoService {
    // todo
    //zhu

    public boolean createVideo(VideoBO videoBO);

    public VideoVO getVideoVODetail(long sourceUserId, long vid);

    public List<VideoVO> getAllVideoList(long sourceUserId, long targetUserId);

    public List<VideoVO> findVideoFeed(long sourceUserId, Date endTime);

    public Date findDateById(long videoId);

    public long findUserIdByVideoId(long videoId);

    //public List<Video> getVideoFeedByTime(Date time);





}

package com.rocky.service;

import com.rocky.bo.VideoBO;
import com.rocky.pojo.Video;
import com.rocky.vo.ResultVO;
import com.rocky.vo.VideoVO;

import java.util.List;

public interface VideoService {
    // todo
    //zhu

    public boolean createVideo(VideoBO videoBO);

    public VideoVO getVideoDetail(long id);

    public List<VideoVO> getAllVideoList();





}

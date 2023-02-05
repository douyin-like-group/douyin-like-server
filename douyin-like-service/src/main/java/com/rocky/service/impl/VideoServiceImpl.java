package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.VideoBO;
import com.rocky.service.VideoService;
import com.rocky.vo.VideoVO;

import java.util.List;

public class VideoServiceImpl extends BaseInfoProperties implements VideoService {
    //todo


    @Override
    public boolean createVideo(VideoBO videoBO) {
        return false;
    }

    @Override
    public VideoVO getVideoDetail(long id) {
        return null;
    }

    @Override
    public List<VideoVO> getAllVideoList() {
        return null;
    }
}

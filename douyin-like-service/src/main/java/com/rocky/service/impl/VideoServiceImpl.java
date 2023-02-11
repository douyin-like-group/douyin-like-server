package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.VideoBO;
import com.rocky.mapper.VideoMapper;
import com.rocky.pojo.Users;
import com.rocky.pojo.Video;
import com.rocky.service.CommentService;
import com.rocky.service.FavoriteService;
import com.rocky.service.UsersService;
import com.rocky.service.VideoService;
import com.rocky.vo.UsersVO;
import com.rocky.vo.VideoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl extends BaseInfoProperties implements VideoService {
    //todo

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private UsersService usersService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CommentService commentService;


    @Override
    public boolean createVideo(VideoBO videoBO) {
        Video video = new Video();
        video.setVideoStatus(videoBO.getVideoStatus());
        video.setCreatedTime(new Date());
        video.setUpdatedTime(new Date());
        video.setCommentsCount(0L);
        video.setCoverUrl(videoBO.getCoverUrl());
        video.setFavoriteCount(0L);
        video.setTitle(videoBO.getTitle());
        video.setPlayUrl(videoBO.getPlayUrl());
        video.setUid(videoBO.getUid());
        videoMapper.insert(video);
        return true;
    }

    @Override
    public VideoVO getVideoVODetail(Video video,long sourceUserId) {
        long videoId = video.getId();
        long targetUserId = video.getUid();
        boolean isFavorite = favoriteService.doesUserLikeVideo(sourceUserId,videoId);
        long  commentCount = commentService.getVideoCommentsCount(videoId);
        long favoriteCount = favoriteService.getVideoBeLIkedCount(videoId);
        UsersVO usersVO = usersService.findById(sourceUserId,targetUserId);
        VideoVO videoVO = new VideoVO(video,usersVO,favoriteCount,commentCount,isFavorite);
        return videoVO;
    }

    @Override
    public List<VideoVO> getAllVideoList(long sourceUserId, long targetUserId) {
        Example videoExample= new Example(Video.class);
        Example.Criteria criteria = videoExample.createCriteria();
        criteria.andEqualTo("uid", targetUserId);
        List<Video> videoList = videoMapper.selectByExample(videoExample);
        List<VideoVO> videoVOList = new ArrayList<VideoVO>();
        for(Video video: videoList){
            VideoVO videoVO = getVideoVODetail(video,sourceUserId);
            videoVOList.add(videoVO);
        }
        return videoVOList;
    }

    @Override
    public List<VideoVO> findVideoFeed(long sourceUserId, Date endTime) {


//        Example videoExample= new Example(Video.class);
//        Example.Criteria criteria = videoExample.createCriteria();
//        videoExample.orderBy("createdTime");
//        List<Video> videoList = videoMapper.selectByExample(videoExample);
        List<Video> videoList  = videoMapper.selectVideoFeedByTime(endTime);


        List<VideoVO> videoVOList = new ArrayList<VideoVO>();
        for(Video video: videoList){
            VideoVO videoVO = getVideoVODetail(video,sourceUserId);
            videoVOList.add(videoVO);
        }
        return videoVOList;

    }

    @Override
    public Date findDateById(long videoId) {

        Video video = videoMapper.selectByPrimaryKey(videoId);
        return video.getCreatedTime();
    }

    @Override
    public long findUserIdByVideoId(long videoId) {

        Video video = videoMapper.selectByPrimaryKey(videoId);

        return video.getUid();
    }
}

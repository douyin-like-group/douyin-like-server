package com.rocky.service;

import com.rocky.bo.VideoBO;
import com.rocky.vo.VideoVO;

import java.util.Date;
import java.util.List;

/**
 * @author zhu
 */
public interface VideoService {
    // todo

    /**
     *
     * @param videoBO
     * @return
     */

    boolean createVideo(VideoBO videoBO);

    /**
     *
     * @param sourceUserId
     * @param vid
     * @return
     */

    VideoVO getVideoVODetail(long sourceUserId, long vid);

    /**
     *
     * @param sourceUserId
     * @param targetUserId
     * @return
     */
    List<VideoVO> getAllVideoList(long sourceUserId, long targetUserId);

    /**
     *
     * @param sourceUserId
     * @param endTime
     * @return
     */
    List<VideoVO> findVideoFeed(long sourceUserId, Date endTime);


    /**
     *
     * @param videoId
     * @return
     */
    Date findDateById(long videoId);

    /**
     *
     * @param videoId
     * @return
     */
    long findUserIdByVideoId(long videoId);

    //public List<Video> getVideoFeedByTime(Date time);

    /**
     *
     * @param videoId
     * @param counts
     */
    public void flushCounts(long videoId, Integer counts);





}

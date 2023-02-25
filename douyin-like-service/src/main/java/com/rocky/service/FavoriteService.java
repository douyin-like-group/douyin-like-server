package com.rocky.service;

import com.rocky.result.ResultVO;


public interface FavoriteService {
    //todo

    /**
     * 点赞操作
     * @param uid
     * @param vid
     * @return
     */
    ResultVO like(long uid, long vid);

    /**
     * 取消点赞操作
     * @param uid
     * @param vid
     * @return
     */
    ResultVO unlike(long uid, long vid);

    /**
     * 获取点赞视频的列表
     * @param uid
     * @return
     */
    ResultVO getlikeList(long uid);

    /**
     * 获取视频点赞数
     * @param vid
     * @return
     */
    long getVideoBeLikedCount(long vid);

    /**
     * 判断用户是否点赞视频
     * @param uid
     * @param vid
     * @return
     */
    boolean doesUserLikeVideo(long uid, long vid);



}

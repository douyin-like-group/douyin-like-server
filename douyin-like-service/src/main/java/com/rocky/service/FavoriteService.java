package com.rocky.service;

import com.rocky.vo.ResultVO;

public interface FavoriteService {
    //todo

    /**
     * 点赞操作
     * @param uid
     * @param vid
     * @return
     */
    public ResultVO like(long uid, long vid);

    /**
     * 取消点赞操作
     * @param uid
     * @param vid
     * @return
     */
    public ResultVO unlike(long uid, long vid);

    /**
     * 获取点赞视频的列表
     * @param uid
     * @return
     */
    public ResultVO getlikeList(long uid);

    /**
     * 获取视频点赞数
     * @param vid
     * @return
     */
    public long getVideoBeLIkedCount(long vid);

    /**
     * 判断用户是否点赞视频
     * @param uid
     * @param vid
     * @return
     */
    public boolean doesUserLikeVideo(long uid, long vid);

}

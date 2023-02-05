package com.rocky.service;

import com.rocky.vo.ResultVO;

public interface FollowService {
    //todo
    //Jiang

    /**
     * 关注操作
     * @param fromUID
     * @param toUID
     * @return
     */
    public ResultVO follow(long fromUID, long toUID);

    /**
     * 取关操作
     * @param fromUID
     * @param toUID
     * @return
     */
    public ResultVO unFollow(long fromUID, long toUID);

    /**
     * 获取关注列表
     * @param uid
     * @return
     */
    public ResultVO getFollowList(long uid);

    /**
     * 获取粉丝列表
     * @param uid
     * @return
     */
    public ResultVO getFollowerList(long uid);

    /**
     * 获取朋友列表
     * @param uid
     * @return
     */
    public ResultVO getFriendList(long uid);

    /**
     * 获取用户关注用户的数量
     * @param uid
     * @return
     */
    public long getFollowCount(long uid);

    /**
     * 获取用户粉丝的数量
     * @param uid
     * @return
     */
    public long getFollowerCount(long uid);

    /**
     * 判断fromId用户是否关注了toId用户
     * @param fromId
     * @param toId
     * @return
     */
    public boolean isFollow(long fromId, long  toId);
}

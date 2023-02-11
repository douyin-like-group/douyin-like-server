package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FavoriteMapper;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Favorite;
import com.rocky.service.FavoriteService;
import com.rocky.service.VideoService;
import com.rocky.vo.ResultVO;
import com.rocky.vo.VideoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class FavoriteServiceImpl extends BaseInfoProperties implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private VideoService videoService;

    @Override
    public ResultVO like(long uid, long vid) {
        // 尝试update数据库中的favorite_status为1，并获取受影响行数
        int lines = favoriteMapper.updateLike(uid, vid);

        if (lines == 0) { // 受影响行数为0，需insert点赞记录到数据库中
            Favorite favorite = new Favorite();
            favorite.setUid(uid);
            favorite.setVid(vid);
            favorite.setFavoriteStatus((byte) 1);
            favorite.setCreateTime(new Date());

            favoriteMapper.insert(favorite);
        }

        return new ResultVO(0, "点赞成功", null, null);
    }

    @Override
    public ResultVO unlike(long uid, long vid) {
        // 尝试update数据库中的favorite_status为0，并获取受影响行数
        int lines = favoriteMapper.updateUnlike(uid, vid);

        return new ResultVO(0, "取消点赞成功", null, null);
    }

    @Override
    public ResultVO getlikeList(long uid) {
        List<Long> vidList = favoriteMapper.selectVIDByUID(uid);

        List<VideoVO> videoVOList = new ArrayList<VideoVO>();
        for (long vid : vidList) {
            // todo 需要组合成List<Video>
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("成功获取喜欢列表");
        resultVO.setData(videoVOList);
        resultVO.setObjectName("video_list");

        return resultVO;
    }

    @Override
    public long getVideoBeLikedCount(long vid) {
        return favoriteMapper.selectFavoriteCountByVID(vid);
    }

    @Override
    public boolean doesUserLikeVideo(long uid, long vid) {
        Favorite favorite = favoriteMapper.selectFavoriteByUIDAndVID(uid, vid);
        if (favorite == null || favorite.getFavoriteStatus() == 0) {
            return false;
        }else {
            return true;
        }
    }
}

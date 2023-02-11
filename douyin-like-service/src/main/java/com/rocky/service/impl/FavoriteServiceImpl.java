package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FavoriteMapper;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Favorite;
import com.rocky.service.FavoriteService;
import com.rocky.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class FavoriteServiceImpl extends BaseInfoProperties implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public ResultVO like(long uid, long vid) {
        // 尝试update数据库中的favorite_status为1，并获取受影响行数
        System.out.println("I am in like()");
        int lines = favoriteMapper.updateLike(uid, vid);
        System.out.println("lines = " + lines);

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
        System.out.println("I am in unlike()");
        int lines = favoriteMapper.updateUnlike(uid, vid);
        System.out.println("lines = " + lines);

        return new ResultVO(0, "取消点赞成功", null, null);
    }

    @Override
    public ResultVO getlikeList(long uid) {
        return null;
    }

    @Override
    public long getVideoBeLIkedCount(long vid) {
        return 10L;
    }

    @Override
    public boolean doesUserLikeVideo(long uid, long vid) {
        return false;
    }
    //todo
}

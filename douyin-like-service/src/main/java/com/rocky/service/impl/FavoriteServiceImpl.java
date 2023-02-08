package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.service.FavoriteService;
import com.rocky.vo.ResultVO;
import org.springframework.stereotype.Service;


@Service
public class FavoriteServiceImpl extends BaseInfoProperties implements FavoriteService {
    @Override
    public ResultVO like(long uid, long vid) {
        return null;
    }

    @Override
    public ResultVO unlike(long uid, long vid) {
        return null;
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

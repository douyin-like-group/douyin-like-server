package com.rocky.service.impl;

import com.rocky.bo.CommentBO;
import com.rocky.mapper.CommentMapper;
import com.rocky.service.CommentService;
import com.rocky.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    //todo
    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentVO queryComment(CommentBO commentBO) {
        return null;
    }

    @Override
    public List<CommentVO> getCommentList(long vid) {
        return null;
    }

    @Override
    public long getVideoCommentsCount(long vid) {
        return commentMapper.getVideoCommentsCountByVid(123);
    }

}

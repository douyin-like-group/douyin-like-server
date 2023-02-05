package com.rocky.service;

import com.rocky.bo.CommentBO;
import com.rocky.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    //todo
    //Lai

    /**
     * 添加新的评论/
     */
    public CommentVO queryComment(CommentBO commentBO);

    public List<CommentVO> getCommentList(long vid);

    public long getVideoCommentsCount(long vid);
}

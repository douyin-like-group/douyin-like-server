package com.rocky.service;

import com.rocky.bo.CommentBO;
import com.rocky.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    //todo
    //Lai

    /**
     * 添加新的评论/
     */
    CommentVO queryComment(long sourceId, CommentBO commentBO);

    List<CommentVO> getCommentList(long vid);

    long getVideoCommentsCount(long vid);
}

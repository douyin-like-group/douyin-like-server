package com.rocky.service.impl;

import com.rocky.bo.CommentBO;
import com.rocky.mapper.CommentMapper;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Comment;
import com.rocky.pojo.Users;
import com.rocky.service.CommentService;
import com.rocky.service.FollowService;
import com.rocky.service.UsersService;
import com.rocky.vo.CommentVO;
import com.rocky.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UsersService usersService;

    @Autowired
    FollowService followService;

    @Override
    public CommentVO queryComment(long sourceId, CommentBO commentBO) {
        Comment comment = new Comment(commentBO.getUid(), commentBO.getVid(), commentBO.getCommentStatus(), commentBO.getContent(), new Date());
        CommentVO commentVO = null;
        int res = 0;
        // 情况一：增加评论
        if (commentBO.getCommentStatus() == 1) {
            res = commentMapper.insertComment(comment);
        //  情况二：删除评论
        }else if (commentBO.getCommentStatus() == 0) {
            res = commentMapper.updateCommentState(commentBO.getCid());
        }

        if (res > 0) {
            UsersVO usersVO = usersService.findById(sourceId, commentBO.getUid());
            //todo：日期格式转化？
            //todo: 检查是否进行数据回填
            commentVO = new CommentVO(comment.getId(), usersVO,
                    comment.getContent(), comment.getCreateTime().toString());
            //CommentVO commentVO = new CommentVO(commentMapper.getCommentID(comment), usersVO,
            //        comment.getContent(), comment.getCreateTime().toString());
            return commentVO;
        }else {
            //todo：抛出异常
            return null;
        }
    }

    @Override
    public List<CommentVO> getCommentList(long sourceId, long vid) {
        if (vid < 0) {
            return null;
        }
        List<Comment> comments = commentMapper.selectCommentsByVid(vid);
        List<CommentVO> commentVOList = null;

        if (comments != null) {
            commentVOList = new ArrayList<>();
            for (Comment comment : comments) {
                UsersVO usersVO = usersService.findById(sourceId, comment.getUid());
                CommentVO commentVO = new CommentVO(comment.getId(), usersVO, comment.getContent(), comment.getCreateTime().toString());
                commentVOList.add(commentVO);
            }
            return commentVOList;
        }else {
            return null;
        }
    }

    @Override
    public long getVideoCommentsCount(long vid) {
        if (vid < 0) {
            return -1;
        }
        return commentMapper.getVideoCommentsCountByVid(vid);
    }
}

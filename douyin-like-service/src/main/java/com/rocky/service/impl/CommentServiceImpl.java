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

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    //todo
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UsersService usersService;

    @Autowired
    FollowService followService;

    @Override
    public CommentVO queryComment(CommentBO commentBO) {
        if (commentBO.getCommentStatus() == 1) {
            Comment comment = new Comment(commentBO.getUid(), commentBO.getVid(), commentBO.getCommentStatus(), commentBO.getContent(), new Date());
            int res = commentMapper.insertComment(comment);
            if (res > 0) {
                CommentVO commentVO = new CommentVO();
                UsersVO usersVO = usersService.getUsersVO();
                commentVO.setUser(usersVO);
                commentVO
            }
        }else {

        }
        return null;
    }

    @Override
    public List<CommentVO> getCommentList(long vid) {
        if (vid < 0) {
            return null;
        }
        List<Comment> comments = commentMapper.selectCommentsByVid(vid);
        List<CommentVO> commentVOList = new ArrayList<>();

        if (comments != null) {
            for (Comment comment : comments) {
                Users user = usersService.findById(comment.getUid());
                UsersVO usersVO = new UsersVO(user.getId(), user.getUsername(), user.getFollowCount(),
                            user.getFollowerCount(), followService.isFollow());
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
        return commentMapper.getVideoCommentsCountByVid(123);
    }

}

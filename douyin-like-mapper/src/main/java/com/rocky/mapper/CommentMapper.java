package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    // 新增评论
    int insertComment(Comment comment);

    // 删除评论
    int updateCommentState(long cid);

    // 获取视频评论
    List<Comment> selectCommentsByVid(long vid);

    // 获取视频总评论数
    long getVideoCommentsCountByVid(long vid);

    // 获得评论cid
    long getCommentID(Comment comment);

}
package com.rocky.mapper;

import com.rocky.my.mapper.MyMapper;
import com.rocky.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    // 新增评论
    //int insertComment(Comment comment);
    //
    //int updateCommentState(long cid);
    //
    //List<Comment> selectCommentsByVid(long vid);

    long getVideoCommentsCountByVid(long vid);

}
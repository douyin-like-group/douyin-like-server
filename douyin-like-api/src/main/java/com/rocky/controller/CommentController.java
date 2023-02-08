package com.rocky.controller;

import com.rocky.service.CommentService;
import com.rocky.vo.CommentVO;
import com.rocky.vo.RegisterLoginVO;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Netter
 * @date: 2023-02-05 18:50
 */
@RestController
@RequestMapping("/douyin/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/list")
    @ResponseBody
    public List<CommentVO> getCommentList(long vid) {
        List<CommentVO> commentList = commentService.getCommentList(vid);
        return commentList;
    }

}

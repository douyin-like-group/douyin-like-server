package com.rocky.controller;

import com.rocky.service.CommentService;
import com.rocky.vo.RegisterLoginVO;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/count")
    @ResponseBody
    public long getCounts(long vid) {
        return commentService.getVideoCommentsCount(vid);
    }

}

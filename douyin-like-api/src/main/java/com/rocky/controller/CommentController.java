package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.CommentBO;
import com.rocky.service.CommentService;
import com.rocky.utils.RedisOperator;
import com.rocky.vo.CommentVO;
import com.rocky.vo.RegisterLoginVO;
import com.rocky.vo.ResultVO;
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
public class CommentController extends BaseInfoProperties {

    @Autowired
    CommentService commentService;

    @PostMapping("/action")
<<<<<<< HEAD
    public ResponseEntity<ResultVO> actionComment(
=======
    public ResultVO actionComment(
>>>>>>> 3e10553ad4bd326a89528135d8c838e79f04fe08
            @RequestParam(required = true, value = "token") String token,
            @RequestParam(required = true, value = "video_id") String videoId,
            @RequestParam(required = true, value = "action_type") String actionType,
            @RequestParam(required = false, value = "comment_text") String commentText,
            @RequestParam(required = false, value = "comment_id") String commentId) {

        // 检查用户状态
        String userId = redis.get(REDIS_USER_TOKEN + ":" + token);
<<<<<<< HEAD
        long sourceUserId;
        if(userId==null){
            sourceUserId = 0L;
        }else{
            sourceUserId = Long.valueOf(userId);
        }

        Byte action = Byte.valueOf(actionType);
        CommentBO commentBO = new CommentBO(sourceUserId, Long.valueOf(videoId),
                commentId.equals("") ? -1 : Long.valueOf(commentId), action, commentText);

        CommentVO commentVO = commentService.queryComment(sourceUserId, commentBO);

        ResultVO resultVO = new ResultVO();
=======
        ResultVO resultVO = new ResultVO();
        if(userId==null){
            resultVO.setStatusMsg("没有权限评论");
            resultVO.setStatusCode(1);
            return resultVO;
        }
        long  sourceUserId = Long.valueOf(userId);


        Byte action = Byte.valueOf(actionType);
        CommentBO commentBO = new CommentBO(sourceUserId, Long.valueOf(videoId),
                (commentId==null)||commentId.equals("") ? -1 : Long.valueOf(commentId), action, commentText);

        CommentVO commentVO = commentService.queryComment(sourceUserId, commentBO);

>>>>>>> 3e10553ad4bd326a89528135d8c838e79f04fe08
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg(action == 1 ? "评论成功" : "删除评论成功");
        resultVO.setData(commentVO);
        resultVO.setObjectName("comment");

<<<<<<< HEAD
        return ResponseEntity.ok(resultVO);
    }

    @GetMapping("/list")
    public List<CommentVO> getCommentList(
            @RequestParam(required = true, value = "token") String token,
            @RequestParam(required = true, value = "video_id") String videoId) {
        List<CommentVO> commentList = commentService.getCommentList(Long.valueOf(videoId));
        return commentList;
=======
        return resultVO;
    }

    @GetMapping("/list")
    public ResultVO getCommentList( @RequestParam(required = true, value = "video_id") String vid) {
        List<CommentVO> commentList = commentService.getCommentList(Long.valueOf(vid));
        ResultVO resultVO = new ResultVO();
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("获取评论列表成功" );
        resultVO.setData(commentList);
        resultVO.setObjectName("comment_list");

        return resultVO;
>>>>>>> 3e10553ad4bd326a89528135d8c838e79f04fe08
    }

}

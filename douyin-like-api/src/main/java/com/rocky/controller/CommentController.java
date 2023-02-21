package com.rocky.controller;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.bo.CommentBO;
import com.rocky.service.CommentService;
import com.rocky.utils.UserAuth;
import com.rocky.vo.CommentVO;
import com.rocky.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @UserAuth
    public ResultVO actionComment(
            @RequestParam(required = true, value = "token") String token,
            @RequestParam(required = true, value = "video_id") String videoId,
            @RequestParam(required = true, value = "action_type") String actionType,
            @RequestParam(required = false, value = "comment_text") String commentText,
            @RequestParam(required = false, value = "comment_id") String commentId) {

        // 检查用户状态
        String userId = redis.get(REDIS_USER_TOKEN + ":" + token);
        ResultVO resultVO = new ResultVO();
        long  sourceUserId = Long.valueOf(userId);


        Byte action = Byte.valueOf(actionType);
        CommentBO commentBO = new CommentBO(sourceUserId, Long.valueOf(videoId),
                (commentId==null)||commentId.equals("") ? -1 : Long.valueOf(commentId), action, commentText);

        CommentVO commentVO = commentService.queryComment(sourceUserId, commentBO);


//        resultVO.setStatusMsg(action == 1 ? "评论成功" : "删除评论成功");

        return ResultVO.ok(ResponseStatusEnum.SUCCESS,"comment",commentVO);
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
    }

}

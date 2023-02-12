package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.service.FollowService;
import com.rocky.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author Jiang
 */
@Slf4j
@RestController
@RequestMapping("/douyin/relation")
public class FollowController extends BaseInfoProperties {
    @Autowired
    private FollowService followService;

    /**
     * 关注或者取关操作
     * @param token
     * @param toUserID
     * @param actionType: 1代表关注，2代表取关
     * @return
     */
    @PostMapping("/action")
    @ResponseBody
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "to_user_id") String toUserIDStr,
                           @RequestParam(name = "action_type") String actionTypeStr) {
         // 获取用户uid
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        if (fromUserIDStr == null) {
            ResultVO resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }
        long fromUserID = Long.parseLong(fromUserIDStr);
        System.out.println("count = " + followService.getFollowCount(250));

        // 根据actionType的值执行关注或取关操作
        long toUserID = Long.parseLong(toUserIDStr);
        byte actionType = Byte.parseByte(actionTypeStr);
        if (actionType == 1) {
            return followService.follow(fromUserID, toUserID);
        } else if (actionType == 2) {
            return followService.unFollow(fromUserID, toUserID);
        }

        return new ResultVO(1, "操作失败", null, null);
    }

    @GetMapping("/follow/list")
    @ResponseBody
    public ResultVO getFollowList(@RequestParam(name = "user_id") String userIDStr,
                                  @RequestParam String token) {
        // 校验token
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        if (fromUserIDStr == null) {
            ResultVO resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }

        long userID = Long.parseLong(userIDStr);

        return followService.getFollowList(userID);
    }

    @GetMapping("/follower/list")
    @ResponseBody
    public ResultVO getFollowerList(@RequestParam(name = "user_id") String userIDStr,
                                  @RequestParam String token) {
        // 校验token
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        if (fromUserIDStr == null) {
            ResultVO resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }
        long userID = Long.parseLong(userIDStr);

        return followService.getFollowerList(userID);
    }

    @GetMapping("/friend/list")
    @ResponseBody
    public ResultVO getFriendList(@RequestParam(name = "user_id") String userIDStr,
                                    @RequestParam String token) {
        // 校验token
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        if (fromUserIDStr == null) {
            ResultVO resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }
        long userID = Long.parseLong(userIDStr);

        return followService.getFriendList(userID);
    }
}

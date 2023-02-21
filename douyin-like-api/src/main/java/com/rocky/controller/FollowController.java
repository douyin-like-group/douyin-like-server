package com.rocky.controller;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.service.FollowService;
import com.rocky.result.ResultVO;
import com.rocky.utils.UserAuth;
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
     * @param toUserIDStr
     * @param actionTypeStr: 1代表关注，2代表取关
     * @return
     */
    @PostMapping("/action")
    @UserAuth
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "to_user_id") String toUserIDStr,
                           @RequestParam(name = "action_type") String actionTypeStr) {
         // 获取用户uid
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
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

        return ResultVO.error(ResponseStatusEnum.FAILED);
    }

    @GetMapping("/follow/list")
    @UserAuth
    public ResultVO getFollowList(@RequestParam(name = "user_id") String userIDStr,
                                  @RequestParam String token) {
        // 校验token
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);

        long userID = Long.parseLong(userIDStr);

        return followService.getFollowList(userID);
    }

    @GetMapping("/follower/list")
    @UserAuth
    public ResultVO getFollowerList(@RequestParam(name = "user_id") String userIDStr,
                                  @RequestParam String token) {
        // 校验token
        log.info("/follower/list接口捕获");
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        long userID = Long.parseLong(userIDStr);

        return followService.getFollowerList(userID);
    }

    @GetMapping("/friend/list")
    @UserAuth
    public ResultVO getFriendList(@RequestParam(required = true, name = "user_id") String userIDStr,
                                    @RequestParam(required = true ,name = "token") String token) throws  Exception{
        // 校验token
        log.info("/friend/list接口捕获");
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        long userID = Long.parseLong(userIDStr);
        return followService.getFriendList(userID);


    }
}

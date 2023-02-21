package com.rocky.controller;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.service.FavoriteService;
import com.rocky.result.ResultVO;
import com.rocky.utils.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/douyin/favorite")
public class FavoriteController extends BaseInfoProperties {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/action")
    @UserAuth
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "video_id") String videoIDStr,
                           @RequestParam(name = "action_type") String actionTypeStr) {
        ResultVO resultVO = null;

        // 获取用户uid
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);

        long userID = Long.parseLong(userIDStr);
        byte actionType = Byte.valueOf(actionTypeStr);
        long videoID = Long.parseLong(videoIDStr);

        if (actionType == 1) { // 点赞
            return favoriteService.like(userID, videoID);
        } else if (actionType == 2) { // 取消点赞
            return favoriteService.unlike(userID, videoID);
        }

        return ResultVO.error(ResponseStatusEnum.FAILED);
    }

    @GetMapping("/list")
    @UserAuth
    public ResultVO getFavoriteList(@RequestParam(name = "user_id") String userID,
                                    @RequestParam String token) {
        // 校验用户token
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);
        return favoriteService.getlikeList(Long.parseLong(userID));
    }
}

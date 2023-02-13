package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.mapper.FavoriteMapper;
import com.rocky.service.FavoriteService;
import com.rocky.service.UsersService;
import com.rocky.service.impl.FavoriteServiceImpl;
import com.rocky.vo.ResultVO;
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
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "video_id") String videoIDStr,
                           @RequestParam(name = "action_type") String actionTypeStr) {
        ResultVO resultVO = null;

        // 获取用户uid
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);
        if (userIDStr == null) {
            resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }
        long userID = Long.parseLong(userIDStr);
        byte actionType = Byte.valueOf(actionTypeStr);
        long videoID = Long.parseLong(videoIDStr);

        if (actionType == 1) { // 点赞
            return favoriteService.like(userID, videoID);
        } else if (actionType == 2) { // 取消点赞
            return favoriteService.unlike(userID, videoID);
        }

        resultVO = new ResultVO();
        resultVO.setStatusCode(1);
        resultVO.setStatusMsg("失败");
        return resultVO;
    }

    @GetMapping("/list")
    public ResultVO getFavoriteList(@RequestParam(name = "user_id") String userID,
                                    @RequestParam String token) {
        // 校验用户token
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);
        if (userIDStr == null) {
            ResultVO resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }

        return favoriteService.getlikeList(Long.parseLong(userID));
    }
}

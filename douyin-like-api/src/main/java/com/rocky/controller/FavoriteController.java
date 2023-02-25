package com.rocky.controller;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.service.VideoService;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.service.FavoriteService;
import com.rocky.result.ResultVO;
import com.rocky.utils.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/douyin/favorite")
@RefreshScope
public class FavoriteController extends BaseInfoProperties {
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private VideoService videoService;

    @Value("${nacos.counts}")
    private Integer nacosCounts;

    @PostMapping("/action")
    @UserAuth
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "video_id") String videoIDStr,
                           @RequestParam(name = "action_type") String actionTypeStr) {
        ResultVO resultVO = null;
        log.info("/douyin/favorite/action 接口捕获");

        // 获取用户uid
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);

        long userID = Long.parseLong(userIDStr);
        byte actionType = Byte.valueOf(actionTypeStr);
        long videoID = Long.parseLong(videoIDStr);


        // 点赞完毕，获得当前在redis中的总数
        // 比如获得总计数为 1k/1w/10w，假定阈值（配置）为2000
        // 此时1k满足2000，则触发入库
        String countsStr = redis.get(REDIS_VLOG_BE_LIKED_COUNTS + ":" + videoID);
//        log.info("======" + REDIS_VLOG_BE_LIKED_COUNTS + ":" + videoID + "======");
        Integer counts = 0;
        if (StringUtils.isNotBlank(countsStr)) {
            counts = Integer.valueOf(countsStr);
            if (counts >= nacosCounts) {
                videoService.flushCounts(videoID, counts);
            }
        }

        if (actionType == 1) { // 点赞

            // 点赞后，视频和视频发布者的获赞都会 +1
//            redis.increment(REDIS_VLOGER_BE_LIKED_COUNTS + ":" + vlogerId, 1);
            redis.increment(REDIS_VLOG_BE_LIKED_COUNTS + ":" + videoID, 1);
            return favoriteService.like(userID, videoID);
        } else if (actionType == 2) { // 取消点赞

            redis.decrement(REDIS_VLOG_BE_LIKED_COUNTS + ":" + videoID, 1);
            return favoriteService.unlike(userID, videoID);
        }

        return ResultVO.error(ResponseStatusEnum.FAILED);
    }

    @GetMapping("/list")
    @UserAuth
    public ResultVO getFavoriteList(@RequestParam(name = "user_id") String userID,
                                    @RequestParam String token) {
        log.info("/douyin/favorite/list/ 接口捕获");

        // 校验用户token
        String userIDStr = redis.get(REDIS_USER_TOKEN + ":" + token);
        return favoriteService.getlikeList(Long.parseLong(userID));
    }
}

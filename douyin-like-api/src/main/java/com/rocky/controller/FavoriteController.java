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
    @ResponseBody
    public ResultVO action(@RequestParam String token,
                           @RequestParam(name = "video_id") long videoID,
                           @RequestParam(name = "action_type") int actionType) {
        log.info("token = " + token + "\n"
                + "video_id = " + videoID + "\n"
                + "action_type = " + actionType);

        return favoriteService.like(1, 101);
    }
}

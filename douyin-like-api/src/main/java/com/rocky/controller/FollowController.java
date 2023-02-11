package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



/**
 * @author Jiang
 */
@Slf4j
@RestController
@RequestMapping("/douyin/relation")
public class FollowController extends BaseInfoProperties {
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
                           @RequestParam(name = "to_user_id") long toUserID,
                           @RequestParam(name = "action_type") int actionType) {
        ResultVO resultVO = null;

         // 获取用户uid
        log.info("token = " + token);
        String fromUserIDStr = redis.get(REDIS_USER_TOKEN+":"+token);
        log.info("fromUserIDStr = " + fromUserIDStr);
        if (fromUserIDStr == null) {
            resultVO = new ResultVO();
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("没有权限访问");
            return resultVO;
        }
        long fromUserID = Long.parseLong(fromUserIDStr);

        // 根据actionType的值执行关注或取关操作
        if (actionType == 1) {

        } else if (actionType == 2) {

        }

        return null;
    }
}

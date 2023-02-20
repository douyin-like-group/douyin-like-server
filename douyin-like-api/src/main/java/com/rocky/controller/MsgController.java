package com.rocky.controller;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.MessageBO;
import com.rocky.pojo.Message;
import com.rocky.service.MessageService;
import com.rocky.vo.MessageVO;
import com.rocky.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/douyin/message")
@Slf4j
public class MsgController extends BaseInfoProperties {

    @Autowired
    private MessageService messageService;

    /**
     * 查询聊天记录
     * @param token
     * @param to_user_id
     * @return
     */
    @GetMapping("/chat")
    public ResponseEntity<ResultVO> queryMsgList(@RequestParam(required = true,value = "token") String token,
                                                  @RequestParam(required = true,value = "to_user_id") String toUserIdStr,
                                                  @RequestParam(required = true,value = "pre_msg_time") String preMsgTimeStr ) {
        log.info("/douyin/message/chat/ 接口捕获");
        MessageVO messageVO = new MessageVO();
        ResultVO resultVO = new ResultVO();
//        long from_user_id = Long.valueOf(token);
        long fromUserId;
        String userId = redis.get(REDIS_USER_TOKEN+":"+token);
        if(userId==null){
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("未找到该用户登陆记录！");
            return ResponseEntity.ok(resultVO);
        }else{
            fromUserId = Long.parseLong(userId);
        }
        resultVO.setStatusCode(0);
        resultVO.setStatusMsg("查询成功！");
        List<MessageVO> messageList = messageService.queryList(fromUserId, Long.parseLong(toUserIdStr),Long.parseLong(preMsgTimeStr));
        resultVO.setData(messageList);
        resultVO.setObjectName("message_list");
        return ResponseEntity.ok(resultVO);
    }

    /**
     * 存储发送消息
     * @param token
     * @param to_user_id
     * @param action_type
     * @param content
     * @return
     */
    @PostMapping("/action")
    public ResponseEntity<ResultVO> saveMsg(@RequestParam String token, String to_user_id, String action_type, String content){
//        log.info("/douyin/message/action 接口捕获");
        //demo
        ResultVO resultVO = new ResultVO();
        long from_user_id ;
        String userId = redis.get(REDIS_USER_TOKEN+":"+token);
        if(userId==null){
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("未找到该用户登陆记录！消息发送失败");
            return ResponseEntity.ok(resultVO);
        }else{
            from_user_id = Long.valueOf(userId);
        }
        MessageBO messageBO = new MessageBO();
        messageBO.setUid(from_user_id);
        messageBO.setVid(Long.parseLong(to_user_id));
        messageBO.setMessage_status((byte) 0);
        messageBO.setContent(content);
        int rs = messageService.createMsg(messageBO);
        if(rs > 0){
            resultVO.setStatusCode(0);
            resultVO.setStatusMsg("消息发送成功！");
        } else {
            resultVO.setStatusCode(1);
            resultVO.setStatusMsg("消息发送失败-");
        }
        return ResponseEntity.ok(resultVO);
    }
}
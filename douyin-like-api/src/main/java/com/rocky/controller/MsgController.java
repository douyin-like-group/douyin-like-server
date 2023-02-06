package com.rocky.controller;

import com.mysql.cj.protocol.MessageListener;
import com.rocky.pojo.Message;
import com.rocky.vo.MessageVO;
import com.rocky.vo.ResultVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/douyin/message")
@Slf4j
public class MsgController {

    @GetMapping("/chat")
    public ResponseEntity<MessageVO> queryMsgList(@RequestParam String token, String to_user_id){
        log.info("/douyin/message/chat/ 接口捕获");
        MessageVO messageVO = new MessageVO();
        messageVO.setStatusCode("0");
        messageVO.setStatusMsg("success");
        Date date = new Date();
        Message[] messageList = new Message[5];
        for(int i=0;i<5;i++){
            Message message = new Message();
            message.setId(new Long((long)i));
            message.setCreateTime(date);
            message.setContent("qqqqqqq");
            messageList[i] = message;
        }
        messageVO.setMessageList(messageList);
        return ResponseEntity.ok(messageVO);
    }

    @PostMapping("/action")
    public ResponseEntity saveMsg(){
        return null;
    }
}

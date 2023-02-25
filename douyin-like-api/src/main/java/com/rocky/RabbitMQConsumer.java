package com.rocky;


import com.rocky.bo.MessageBO;
import com.rocky.exceptions.MyCustomException;
import com.rocky.result.MessageEnum;
import com.rocky.result.ResponseStatusEnum;
import com.rocky.service.MessageService;
import com.rocky.service.UsersService;
import com.rocky.utils.JsonUtils;
import com.rocky.utils.RabbitMQConfig;
import com.rocky.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumer {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UsersService usersService;

    @RabbitListener(queues = {RabbitMQConfig.QUEUE_SYS_MSG})
    public void watchQueue(String payload, Message message) {
        log.info(payload);

        MessageBO messageBO = JsonUtils.jsonToPojo(payload, MessageBO.class);

        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        log.info(routingKey);

        // TODO: 下面这段代码可以优化，一个地方是参数优化，另外是枚举的判断优化
        // todo: 可以增加创建消息，比如你关注的人给你评论了之类的

        if (routingKey.equalsIgnoreCase("sys.msg." + MessageEnum.FOLLOW_YOU.enValue)) {
            UsersVO usersVO = usersService.findById(1L,messageBO.getUid());
            messageBO.setContent(usersVO.getName()+"关注你啦！");
            messageService.createMsg(messageBO);
        } else {
            throw new MyCustomException(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }

    }


}

package com.rocky.controller;

import com.rocky.RabbitMQConfig;
import com.rocky.result.GraceJSONResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${nacos.counts}")
    private Integer nacosCounts;

    @GetMapping("hello")
    public Object hello() {
        return GraceJSONResult.ok( "Hello SpringBoot~");
    }


    @GetMapping("nacosCounts")
    public Object nacosCounts() {
        return GraceJSONResult.ok("nacosCounts的数值为：" + nacosCounts);
    }

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping("produce")
    public Object produce() throws Exception {


        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_MSG,
                "sys.msg.send",
                "我发了一个消息~~");


        /**
         * 路由规则
         * route-key
         * display.
         *      display.a.b
         *      display.public.msg
         *      display.a.b.c
         *      * 代表一个占位符
         *
         *  display.#
         *      display.a.b
         *      display.a.b.c.d
         *      display.public.msg
         *      display.delete.msg.do
         *      # 代表多个占位符
         *
         */

        return GraceJSONResult.ok();
    }

    @GetMapping("produce2")
    public Object produce2() throws Exception {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_MSG,
                "sys.msg.delete",
                "我删除了一个消息~~");

        return GraceJSONResult.ok();
    }

}

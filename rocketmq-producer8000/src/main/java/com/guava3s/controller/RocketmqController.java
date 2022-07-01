package com.guava3s.controller;

import com.guava3s.bean.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Micolen
 * @version 1.0
 * @ClassName RocketmqController
 * @date 2022/6/22 11:28
 * @mail 2168626265@qq.com
 */
@Slf4j
@RestController
public class RocketmqController {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/insert/{message}")
    public String insertMessage(@PathVariable String message) {
        log.info("收到的信息为：{}", message);
        rocketMQTemplate.convertAndSend("first-topic", message);
        return "插入成功";
    }

    @GetMapping("/test")
    public String test() {
        TestEntity entity = new TestEntity();
        entity.setId("123456");
        entity.setMessage("你好啊");
        rocketMQTemplate.convertAndSend("first-topic", entity);
        return "测试成功";
    }
}

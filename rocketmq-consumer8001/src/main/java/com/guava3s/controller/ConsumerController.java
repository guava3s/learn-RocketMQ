package com.guava3s.controller;

import com.guava3s.bean.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Micolen
 * @version 1.0
 * @ClassName ConsumerController
 * @date 2022/6/30 16:52
 * @mail 2168626265@qq.com
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "my-consumer-group")
public class ConsumerController implements RocketMQListener<TestEntity> {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void onMessage(TestEntity message) {
        log.info("消费的数据为：{}", message);
    }
}

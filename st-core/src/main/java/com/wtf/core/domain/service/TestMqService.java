package com.wtf.core.domain.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * The type Test mq service.
 */
@Service
@RabbitListener(queues = "hello")
public class TestMqService {

    /**
     * Do some.
     *
     * @param hello the hello
     */
    @RabbitHandler
    public void doSome(String hello) {
        System.out.println("hello = " + hello);
    }
}

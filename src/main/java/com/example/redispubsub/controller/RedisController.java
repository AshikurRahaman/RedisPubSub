package com.example.redispubsub.controller;

import com.example.redispubsub.configuration.RedisMessagePublisher;
import com.example.redispubsub.configuration.RedisMessageSubscriber;
import com.example.redispubsub.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class RedisController {
    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Autowired
    private RedisMessageSubscriber redisMessageSubscriber;


    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        logger.info("publishing ", message);
        redisMessagePublisher.publish(message.toString());
    }

    @GetMapping("/messages")
    public List<String> getMessages(){
        return RedisMessageSubscriber.messageList;
    }

}

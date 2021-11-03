package com.example.redispubsub.configuration;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisMessageSubscriber implements MessageListener {

    public static List<String> messageList = new ArrayList<>();

    @Override
    //when message published, this method triggers
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println(message.toString());
    }
}

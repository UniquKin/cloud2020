package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    @Output(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(s).build());
        System.out.println("*****serial: "+s);
        return null;
    }
}

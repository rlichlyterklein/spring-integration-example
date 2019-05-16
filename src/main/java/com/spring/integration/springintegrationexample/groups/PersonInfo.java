package com.spring.integration.springintegrationexample.groups;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonInfo {

    @Bean
    @GlobalChannelInterceptor(patterns={"outputToLog"})
    public ChannelInterceptor messageChannelInterceptor() {
        ChannelInterceptor channelInterceptor = new ChannelInterceptor() {

            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                log.info("Before: " + message);
                return message;
            }

            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
                log.info("After: " + message);
            }
        };
        return channelInterceptor;
    }

    @ServiceActivator(inputChannel = "woman", outputChannel = "outputToLog")
    public String printWomanInfo(@Payload Person person, @Header("testHeader") String testHeader) {
        log.info("Woman info: {} {}", person.getName(), testHeader);
        return person.getName();
    }

    @ServiceActivator(inputChannel = "man", outputChannel ="outputToLog")
    public String printManInfo(@Payload Person person, @Header("testHeader") String testHeader) {
        log.info("Man info: {} {}", person.getName(), testHeader);
        return person.getName();
    }

    @ServiceActivator(inputChannel = "outputToLog")
    public void toLog(String name) {
        log.info(name);
    }


}

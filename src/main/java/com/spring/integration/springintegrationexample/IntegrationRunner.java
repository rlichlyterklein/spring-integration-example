package com.spring.integration.springintegrationexample;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IntegrationRunner implements CommandLineRunner {

    private MessageChannel textInChannel;

    @Override
    public void run(String... args) throws Exception {
        String test = "Hello World";
        Message<String> build = MessageBuilder.withPayload(test).build();
        this.textInChannel.send(build);
    }
}

package com.spring.integration.springintegrationexample;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@AllArgsConstructor
public class IntegrationConfig {

    private SampleHandler sampleHandler;


    @Bean
    public IntegrationFlow exportFlow() {
        return IntegrationFlows.from("sample")
                .handle(sampleHandler)
                .<String, String>transform(text -> text.toUpperCase())
                .channel("fileWriterChannel")
                .get();
    }

    @Bean
    public MessageChannel textInChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel sampleInChannel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel="textInChannel",
            outputChannel="fileWriterChannel")
    public GenericTransformer<String, String> upperCaseTransformer() {
        return text -> text.toUpperCase();
    }

    @Bean
    @ServiceActivator(inputChannel="fileWriterChannel")
    public FileWritingMessageHandler fileWriter() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("/tmp/sia5/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }



}

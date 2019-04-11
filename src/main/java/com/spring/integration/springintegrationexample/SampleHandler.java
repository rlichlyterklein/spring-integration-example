package com.spring.integration.springintegrationexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleHandler implements GenericHandler<IntegrationSample> {

    @Override
    public String handle(IntegrationSample sample, MessageHeaders messageHeaders) {
        log.info(sample.getName());
        return sample.getName();
    }
}

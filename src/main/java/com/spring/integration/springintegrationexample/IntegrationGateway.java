package com.spring.integration.springintegrationexample;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = "sample")
    void addSample(@Payload IntegrationSample sample, @Header("test") String test);

}

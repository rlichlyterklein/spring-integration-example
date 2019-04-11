package com.spring.integration.springintegrationexample;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.List;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = "sample")
    void addSample(List<IntegrationSample> sample);

}

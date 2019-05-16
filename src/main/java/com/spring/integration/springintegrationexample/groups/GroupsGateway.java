package com.spring.integration.springintegrationexample.groups;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@MessagingGateway
public interface GroupsGateway  {

    @Gateway(requestChannel = "groups")
    void addGroup(@Payload Group group, @Header("testHeader") String testHeader);
}

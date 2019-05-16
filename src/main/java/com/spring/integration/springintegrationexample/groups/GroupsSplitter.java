package com.spring.integration.springintegrationexample.groups;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@MessageEndpoint
public class GroupsSplitter {

    @Splitter(inputChannel = "groups", outputChannel = "people")
    public List<Person> splitGrooups(@Payload Group group, @Header("testHeader") String testHeader) {
        return group.getPeople();
    }
}

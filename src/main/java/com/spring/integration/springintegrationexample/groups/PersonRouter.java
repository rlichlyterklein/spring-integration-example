package com.spring.integration.springintegrationexample.groups;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@MessageEndpoint
public class PersonRouter {

    @Router(inputChannel = "people")
    public String resolveGender(@Payload Person person, @Header("testHeader") String testHeader) {
        return (person.getGender().equals("female")) ? "woman": "man";
    }

}

package com.spring.integration.springintegrationexample.groups;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.test.context.MockIntegrationContext;
import org.springframework.integration.test.context.SpringIntegrationTest;
import org.springframework.integration.test.mock.MockMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.integration.test.mock.MockIntegration.mockMessageHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringIntegrationTest
public class PersonInfoTest {

    @Autowired
    private MockIntegrationContext mockIntegrationContext;

    @Autowired
    @Qualifier("woman")
    private DirectChannel womanChannel;

    @Autowired
    private PersonInfo personInfo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test_personInfo() {

        ArgumentCaptor<Message<?>> captor = ArgumentCaptor.forClass(Message.class);

        MockMessageHandler mockMessageHandler = mockMessageHandler(captor)
                .handleNext(message -> {
                    assertNotNull(message);
                });
        mockIntegrationContext.substituteMessageHandlerFor( "personInfo.toLog.serviceActivator",
                mockMessageHandler);

        //personInfo.printWomanInfo(, "testing");

        this.womanChannel.send(MessageBuilder.withPayload(Person.builder().name("test").build())
                .setHeader("testHeader", "blah").build());


    }
}
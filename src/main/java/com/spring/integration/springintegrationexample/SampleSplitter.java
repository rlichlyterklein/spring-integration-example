package com.spring.integration.springintegrationexample;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import java.util.List;

@MessageEndpoint
public class SampleSplitter {

    @Splitter(inputChannel = "sample", outputChannel = "textInChannel")
    public String getSample(List<IntegrationSample> sampleList) {
        return sampleList.remove(0).getName();
    }

}

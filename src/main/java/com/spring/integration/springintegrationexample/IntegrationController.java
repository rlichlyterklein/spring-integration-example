package com.spring.integration.springintegrationexample;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@RestController
public class IntegrationController {

    private IntegrationGateway gateway;

    @PostMapping("sample")
    public Mono<IntegrationSample> saveSample(@RequestBody final List<IntegrationSample> sample) {
        gateway.addSample(sample);
        return Mono.just(sample.get(0));
    }


}

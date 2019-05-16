package com.spring.integration.springintegrationexample.groups;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class GroupRunner implements CommandLineRunner {

    private GroupsGateway groupsGateway;

    @Override
    public void run(String... args) throws Exception {
        Group group = Group.builder()
                .groupName("Doctor 12")
                .id("doctor")
                .people(Arrays.asList(Person.builder().name("Doctor").gender("male").build(),
                        Person.builder().name("Carla").gender("female").build()))
                .build();
        log.info(group.getGroupName());
        groupsGateway.addGroup(group, UUID.randomUUID().toString());
    }
}

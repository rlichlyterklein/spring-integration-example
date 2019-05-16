package com.spring.integration.springintegrationexample.groups;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String gender;
}

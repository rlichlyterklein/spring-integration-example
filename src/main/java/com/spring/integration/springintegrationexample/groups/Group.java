package com.spring.integration.springintegrationexample.groups;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Group {
    private String id;
    private String groupName;
    private List<Person> people;


}

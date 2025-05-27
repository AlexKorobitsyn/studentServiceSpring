package org.alexk.studentsspringproject.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Student {
    private Integer id;
    private String name;
    private int age;
    private String secondName;
    private String gender;
    private String email;
}

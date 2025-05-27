package org.alexk.studentsspringproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;



@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long secretdbid;  // внутренний ID (primary key в БД)

    private Integer id;       // внешний ID, может быть уникальным
    private String name;
    private String secondName;
    private Integer age;
    private String gender;
    private String email;
}


package com.oracle.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    public Student(){
        System.out.println("Default Constructor !");
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ss")
    @SequenceGenerator(name = "ss",sequenceName = "studentSequence",initialValue = 1,allocationSize = 1)
    @Column(nullable = false,updatable = false)
    private Integer sId;
    @Column(name="student_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
}

package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = {"projects"})
@ToString(exclude = {"projects"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "es")
    @SequenceGenerator(name = "es",sequenceName = "emp_seq",initialValue = 1000,allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name = "emp_id",nullable = false,updatable = false)
    private Integer eId;
    @ManyToMany(mappedBy = "employees",fetch = FetchType.EAGER)
    List<Project> projects;
    @Column(name = "first_name",nullable = false,updatable = true)
    private String firstName;
    @Column(name = "last_name",nullable = false,updatable = true)
    private String lastName;
    @Column(name = "emp_salary",nullable = false,updatable = true)
    private Double salary;
}

package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = "projectList")
@EqualsAndHashCode(exclude = "projectList")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "es")
    @SequenceGenerator(name = "es",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
    @Column(name = "emp_id",updatable = false,nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name = "first_name",nullable = false,updatable = true)
    private String firstName;
    @Column(name = "last_name",nullable = false,updatable = true)
    private String lastName;
    @ManyToMany(mappedBy = "employeeList")
    private List<Project> projectList;

}

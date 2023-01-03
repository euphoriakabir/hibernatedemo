package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = "employeeList")
@EqualsAndHashCode(exclude = "employeeList")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ps")
    @SequenceGenerator(name = "ps",sequenceName = "project_seq",initialValue = 1,allocationSize = 1)
    @Column(name = "project_id",updatable = false,nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name="project_name",nullable = false,updatable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name="start_date",nullable = false,updatable = false)
    private Calendar startDate;
    @ManyToMany
    @JoinTable(name = "project_emp",joinColumns = {@JoinColumn(name="project_key")},inverseJoinColumns = {@JoinColumn(name="emp_key")})
    private List<Employee> employeeList;
}

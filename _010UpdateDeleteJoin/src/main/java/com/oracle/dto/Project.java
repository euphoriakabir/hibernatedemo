package com.oracle.dto;

import lombok.*;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@ToString(exclude = "employees")
@EqualsAndHashCode(exclude = "employees")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ps")
    @SequenceGenerator(name = "ps",sequenceName = "pro_seq",initialValue = 1,allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name = "pro_id",updatable = false,nullable = false)
    private Integer pId;
    @ManyToMany
    @JoinTable(name = "joinTable_EmpPro",joinColumns = {@JoinColumn(name = "project_id")},inverseJoinColumns = {@JoinColumn(name="emp_id")})
    private List<Employee> employees;
    @Column(name="project_name",nullable = false,unique = true)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date",nullable = false,unique = false)
    private Calendar startDate;
}

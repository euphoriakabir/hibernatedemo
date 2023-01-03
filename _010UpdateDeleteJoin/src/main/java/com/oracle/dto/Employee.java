package com.oracle.dto;

import com.sun.xml.internal.ws.developer.StreamingAttachment;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = "projects")
@EqualsAndHashCode(exclude = "projects")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "es")
    @SequenceGenerator(name = "es",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name = "emp_id",updatable = false,nullable = false)
    private Integer eId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar doj;
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
}

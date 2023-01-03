package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "empS")
    @SequenceGenerator(name = "empS",sequenceName = "eseq",initialValue = 1,allocationSize = 1)
    @Column(name = "emp_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Integer empId;
    @Column(nullable = false,name="first_name")
    private String firstName;
    @Column(nullable = false,name="last_name")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth")
    private Date dob;
    @Lob
    @Column(name="emp_image")
    private byte[] image;
}

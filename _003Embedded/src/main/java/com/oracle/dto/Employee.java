package com.oracle.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "es")
    @SequenceGenerator(sequenceName = "empSeq",name = "es",initialValue = 1,allocationSize = 1)
    @Column(name = "emp_id",nullable = false,updatable = false)
    private Integer empId;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    private Address address;
}

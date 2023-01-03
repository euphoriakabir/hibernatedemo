package com.oracle.dto3;

import com.oracle.dto3.Company;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "empseq")
    @SequenceGenerator(name = "empseq",sequenceName = "emp_seq",initialValue = 1000,allocationSize = 1)
    @Column(name = "emp_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Long empId;
    @Column(name="emp_name",nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name="emp_dob")
    private Date dob;
    @ManyToOne
    private Company company;
}

package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class AadharDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "as")
    @SequenceGenerator(name = "as",sequenceName = "aadhar_id",initialValue = 10000000,allocationSize = 1)
    @Column(name = "aadhar_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Long aadharId;
    @Column(name="city",nullable = false)
    private String city;
    @Column(name="state",nullable = false)
    private String state;
}

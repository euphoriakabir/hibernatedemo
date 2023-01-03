package com.oracle.dto;

import lombok.Data;

import javax.persistence.Embeddable;
@Data
@Embeddable
public class Address {
    private String street;
    private String city;
}

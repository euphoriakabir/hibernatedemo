package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Device {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ds")
    @SequenceGenerator(name = "ds",sequenceName = "dseq",initialValue = 1,allocationSize = 1)
    @Column(name = "device_id",updatable = false,nullable = false)
    private Integer dId;
    @Column(name="device_name",nullable = false,updatable = false)
    private String name;
    @Column(name="device_price",nullable = false,updatable = true)
    private Double price;
    @OneToMany
    @JoinTable(name = "joinTableX",joinColumns = {@JoinColumn(name = "device_id")},inverseJoinColumns = {@JoinColumn(name="component_id")})
    List<Component> components;
}

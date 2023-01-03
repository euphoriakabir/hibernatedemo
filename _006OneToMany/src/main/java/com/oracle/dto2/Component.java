package com.oracle.dto2;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cs")
    @SequenceGenerator(name = "cs",sequenceName = "comp_seq",allocationSize = 1,initialValue = 1)
    @Column(name = "component_Id",updatable = false,nullable = false)
    @Setter(AccessLevel.NONE)
    private Long componentId;
    @Column(name="component_price",nullable = false)
    private Double price;
    @Column(name="component_manufacturer",nullable = true)
    private String manufacturer;
    @Column(name="component_name")
    private String name;
}

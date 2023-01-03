package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Component {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cs")
    @SequenceGenerator(name = "cs",sequenceName = "cseq",initialValue = 1,allocationSize = 1)
    @Column(name = "component_id",updatable = false,nullable = false)
    private Integer cId;
    @Column(name="component_name",nullable = false,updatable = false)
    private String name;
    @Column(name="component_price",nullable = false,updatable = true)
    private Double price;
}

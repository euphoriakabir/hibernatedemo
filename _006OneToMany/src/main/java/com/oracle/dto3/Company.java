package com.oracle.dto3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "compseq")
    @SequenceGenerator(name = "compseq",sequenceName = "company_seq",initialValue = 1000,allocationSize = 1)
    @Column(name = "comp_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name="comp_name",updatable = true,nullable = true)
    private String name;
    @Column(name="company_category",updatable = true,nullable = false)
    private String category;

}

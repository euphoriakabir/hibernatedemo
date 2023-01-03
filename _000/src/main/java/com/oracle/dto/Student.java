package com.oracle.dto;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "sSeq")
    @SequenceGenerator(name = "sSeq",initialValue = 1,allocationSize = 1)
    @Column(name = "sId",updatable = false,nullable = false)
    private Integer sId;
    @Column
    private String firstName;
    @Column
    private String lastName;
}

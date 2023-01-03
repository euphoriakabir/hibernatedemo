package com.oracle.dto;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "as")
    @SequenceGenerator(name = "as",sequenceName = "accSeq",initialValue = 10000000,allocationSize = 1)
    @Column(name = "account_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Long accountId;
    @Column(name = "branch",nullable = false,updatable = false)
    private Integer branch;
    @Column(name = "balance",nullable = false,updatable = false)
    private Double balance;
}

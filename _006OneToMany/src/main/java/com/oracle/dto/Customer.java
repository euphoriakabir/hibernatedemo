package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = "accountList")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cs")
    @SequenceGenerator(name = "cs",sequenceName = "custSeq",initialValue = 70000000,allocationSize = 1)
    @Column(name = "customer_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Long customerId;
    @Column(name="first_name",updatable = false,nullable = false)
    private String firstName;
    @Column(name="last_name",updatable = true,nullable = true)
    private String lastName;
    @OneToMany
    private List<Account> accountList;
}

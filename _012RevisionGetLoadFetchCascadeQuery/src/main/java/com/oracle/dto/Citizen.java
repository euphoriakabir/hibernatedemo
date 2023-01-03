package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cid")
    @SequenceGenerator(name = "cid", sequenceName = "c_id", initialValue = 1000, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name = "citizen_id", updatable = false, nullable = false)
    private Long cId;
    @Column(name = "first_name", nullable = false, updatable = true)
    private String firstName;
    @Column(name = "last_name", nullable = true, updatable = true)
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "joining_date", nullable = false, updatable = false)
    private Date joiningDate;
    @ManyToMany
    @JoinTable(name = "citizen_bank",
            joinColumns = {@JoinColumn(name = "citizen_id")},
            inverseJoinColumns = {@JoinColumn(name = "account_id")})
    private List<BankAccount> accounts;
}

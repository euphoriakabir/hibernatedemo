package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "bid")
    @SequenceGenerator(name = "bid",sequenceName = "b_id",initialValue = 2000,allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name="bank_id",updatable = false,nullable = false)
    private Long bId;
    private Integer branchCode;
    private Double accountBalance;
    @Temporal(TemporalType.DATE)
    @Column(name="account_opening_date",updatable = false,nullable = false)
    private Date accountOpeningDate;
}

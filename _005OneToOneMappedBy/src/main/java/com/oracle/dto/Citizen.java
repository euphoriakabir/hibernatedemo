package com.oracle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString(exclude = "aadharDetails")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cs")
    @SequenceGenerator(name = "cs",sequenceName = "citizen_id",initialValue = 1,allocationSize = 1)
    @Column(name = "citizen_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Integer citizenId;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @OneToOne(mappedBy = "citizen")
    @JoinColumn(name = "aadharDetails")
    private AadharDetails aadharDetails;
}

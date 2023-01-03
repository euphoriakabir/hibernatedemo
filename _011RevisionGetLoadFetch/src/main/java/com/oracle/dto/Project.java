package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = {"employees"})
@ToString(exclude = {"employees"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ps")
    @SequenceGenerator(name = "ps", sequenceName = "project_seq", initialValue = 2000, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    @Column(name = "proect_id", nullable = false, updatable = false)
    private Integer pId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "projectsemployee_jointable",
            joinColumns = {
                    @JoinColumn(name = "project_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "emp_id")
            }
    )
    private List<Employee> employees;
    @Column(name = "project_name", nullable = false, updatable = true)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, updatable = true)
    private Date startDate;
    @Column(name = "project_cost", nullable = false, updatable = false)
    private Double projectCost;
}

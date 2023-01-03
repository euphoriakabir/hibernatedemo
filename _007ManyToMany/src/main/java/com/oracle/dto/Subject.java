package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"trainees"})
@EqualsAndHashCode(exclude = {"trainees"})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ss")
    @SequenceGenerator(name = "ss",sequenceName = "subject_sequence",initialValue = 1,allocationSize = 1)
    @Column(name="subject_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name="subject_name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Trainee> trainees;
}

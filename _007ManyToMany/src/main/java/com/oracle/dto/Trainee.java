package com.oracle.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"subjects"})
@EqualsAndHashCode(exclude = {"subjects"})
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ts")
    @SequenceGenerator(name = "ts",sequenceName = "trainee_sequence",initialValue = 1,allocationSize = 1)
    @Column(name="trainee_id",nullable = false,updatable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name="trainee_name")
    private String name;
    @ManyToMany(mappedBy = "trainees")
    private List<Subject> subjects;
}

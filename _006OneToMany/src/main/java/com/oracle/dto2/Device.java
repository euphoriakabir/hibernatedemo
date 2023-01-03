package com.oracle.dto2;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = "components")
@EqualsAndHashCode(exclude = "components")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ds")
    @SequenceGenerator(name = "ds",sequenceName = "dev_seq",allocationSize = 1,initialValue = 1)
    @Column(name = "device_Id",updatable = false,nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer deviceId;
    @OneToMany
    List<Component> components;
    @Column(name="device_name",nullable = false)
    private String name;
    @Column(name="origin_country")
    private String origin;
}

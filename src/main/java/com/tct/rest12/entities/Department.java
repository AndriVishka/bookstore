package com.tct.rest12.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column
    private String name;

}

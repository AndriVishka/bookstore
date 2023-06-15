package com.tct.rest12.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column
    private String name;

    @Column(columnDefinition = "integer default 1", nullable = true)
    private Integer credits;

    @Column
    private Integer departmentId;
}

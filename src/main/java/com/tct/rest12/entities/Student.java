package com.tct.rest12.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer age;

    @Column
    private Integer departmentId;

}

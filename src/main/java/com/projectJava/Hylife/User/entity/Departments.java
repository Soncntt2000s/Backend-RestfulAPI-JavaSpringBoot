package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Departments implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description",columnDefinition = "text default NULL")
    private TextArea description;

    public Departments(Integer id, String name, TextArea description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Departments() {
    }
}

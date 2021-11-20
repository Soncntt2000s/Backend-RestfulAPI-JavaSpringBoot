package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "branchs")
@Getter
@Setter
public class Branchs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",columnDefinition = "int(11)")
    private int id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description",columnDefinition = "text default NULL")
    private TextArea description;

    public Branchs(int id, String name, TextArea description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Branchs() {
    }
}

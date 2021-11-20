package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "positions")
@Getter
@Setter
public class Positions extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description",columnDefinition = "varchar(255) default NULL",nullable = true)
    private String description;



    public Positions(Integer id,String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Positions() {
    }
}

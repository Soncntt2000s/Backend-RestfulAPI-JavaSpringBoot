package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "positions")
@Getter
@Setter
public class Positions extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    @NotNull
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

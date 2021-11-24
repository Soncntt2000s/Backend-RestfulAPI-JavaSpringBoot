package com.projectJava.Hylife.User.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
@Getter
@Setter
public class Positions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @OneToMany(mappedBy = "positions",fetch = FetchType.LAZY)
    private Set<UserProfile> userProfile = new HashSet<>();

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

package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Departments implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<UserProfile> userProfile = new HashSet<>();

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description",columnDefinition = "text default NULL")
    private String description;

    public Departments(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Departments() {
    }
}

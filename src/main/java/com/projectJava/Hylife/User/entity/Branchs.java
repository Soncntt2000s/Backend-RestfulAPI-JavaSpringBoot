package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "branchs")
@Getter
@Setter
public class Branchs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",columnDefinition = "int(11)")
    private int id;

    @OneToMany(mappedBy = "branch",fetch = FetchType.LAZY)
    private Set<UserProfile> userProfile = new HashSet<>();

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description",columnDefinition = "text default NULL")
    private String description;

    public Branchs(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Branchs() {
    }
}

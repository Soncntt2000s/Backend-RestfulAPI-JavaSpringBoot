package com.projectJava.Hylife.User.entity;

import com.projectJava.Hylife.User.common.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Roles extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @Column(name = "description",columnDefinition = "varchar(255) default NULL",nullable = true)
    private String description;

    public Roles(Integer id, ERole name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Roles() {
    }

}

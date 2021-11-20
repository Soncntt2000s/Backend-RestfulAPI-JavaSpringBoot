package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "catagories")
@Getter
@Setter
public class Catagories extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "catagory_parent_id",referencedColumnName = "id"
            ,columnDefinition = "int(11) default NULL",nullable = true)
    private Catagories catagories;

    @Column(name = "slug",columnDefinition = "varchar(255)")
    private String slug;

    public Catagories(Integer id, String name, Catagories catagories, String slug) {
        this.id = id;
        this.name = name;
        this.catagories = catagories;
        this.slug = slug;
    }

    public Catagories() {
    }
}

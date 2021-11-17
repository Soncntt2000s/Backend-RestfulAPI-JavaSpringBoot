package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
    @NotNull
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

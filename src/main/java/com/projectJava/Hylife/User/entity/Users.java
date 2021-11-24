package com.projectJava.Hylife.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)")
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles", joinColumns = @JoinColumn(name = "user_id",columnDefinition = "int(11) NOT NULL")
            , inverseJoinColumns = @JoinColumn(name = "role_id",columnDefinition = "int(11) NOT NULL"))
    private Set<Roles> roles = new HashSet<>();

    //Một User viết nhiều Post
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(name = "user_id")
//    private List<Posts> posts = new ArrayList<>();


    @Column(name = "status", columnDefinition = "tinyint(1)")
    private Boolean status;

    @Column(name = "email", columnDefinition = "varchar(255)",unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255)",nullable = false)
    private String password;

    @Column(name = "login_token", columnDefinition = "varchar(255)", nullable = true)
    private String loginToken;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @Column(name = "updated_at",columnDefinition = "timestamp default NULL")
    private Timestamp updatedAt;

    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public Users(String email, String password, Set<Roles> roles, Boolean status, Timestamp createdAt) {
        this.roles = roles;
        this.status = status;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}

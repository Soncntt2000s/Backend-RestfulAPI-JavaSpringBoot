package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)")
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @Column(name = "status", columnDefinition = "tinyint(1)")
    private Integer status;

    @Column(name = "email", columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "login_token", columnDefinition = "varchar(255)", nullable = true)
    private String login_token;

    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

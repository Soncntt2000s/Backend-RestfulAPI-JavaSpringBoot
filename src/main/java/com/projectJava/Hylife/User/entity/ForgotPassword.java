package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "forgot_password")
@Getter
@Setter
public class ForgotPassword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "email",columnDefinition = "varchar(255)",unique = true)
    private String email;

    @Column(name = "token",columnDefinition = "varchar(255)")
    private String token;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    public ForgotPassword(Integer id, String email, String token, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.createdAt = createdAt;
    }

    public ForgotPassword() {
    }
}

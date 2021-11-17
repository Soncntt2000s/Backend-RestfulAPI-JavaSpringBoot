package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bouncycastle.util.Times;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "forgot_password")
@Getter
@Setter
public class ForgotPassword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email",columnDefinition = "varchar(255)",unique = true)
    @NotNull
    private String email;

    @Column(name = "token",columnDefinition = "varchar(255)")
    @NotNull
    private String token;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    @NotNull
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

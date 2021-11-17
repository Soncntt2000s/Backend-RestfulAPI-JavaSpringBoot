package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "hybox")
@Getter
@Setter
public class Hyboxs extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "confession")
    private TextArea confession;

    @Column(name = "user_sender")
    private String user_sender;

    @Column(name = "user_receiver")
    private String user_receiver;



    public Hyboxs(Integer id, TextArea confession, String user_sender, String user_receiver) {
        this.id = id;
        this.confession = confession;
        this.user_sender = user_sender;
        this.user_receiver = user_receiver;
    }

    public Hyboxs() {
    }

}

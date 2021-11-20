package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "hybox")
@Getter
@Setter
public class Hyboxs extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "confession")
    private TextArea confession;

    @Column(name = "user_sender")
    private String user_sender;

    @Column(name = "user_receiver")
    private String userReceiver;



    public Hyboxs(Integer id, TextArea confession, String user_sender, String userReceiver) {
        this.id = id;
        this.confession = confession;
        this.user_sender = user_sender;
        this.userReceiver = userReceiver;
    }

    public Hyboxs() {
    }

}

package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "banners")
@Getter
@Setter
public class Banners implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "title",columnDefinition = "varchar(255)")
    private String title;

    @Column(name = "content",columnDefinition = "varchar(255)")
    private String content;

    @Column(name = "url_img",columnDefinition = "varchar(255)")
    private String urlImg;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @Column(name = "updated_at",columnDefinition = "timestamp default NULL")
    private Timestamp updatedAt;


    public Banners(String title, String content, String urlImg,Timestamp createdAt) {
        this.title = title;
        this.content = content;
        this.urlImg = urlImg;
        this.createdAt = createdAt;
    }

    public Banners() {
    }
}

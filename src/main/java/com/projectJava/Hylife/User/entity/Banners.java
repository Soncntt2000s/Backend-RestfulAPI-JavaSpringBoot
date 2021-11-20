package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "banners")
@Getter
@Setter
public class Banners extends BaseEntity {

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


    public Banners(Integer id, String title, String content, String urlImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.urlImg = urlImg;
    }

    public Banners() {
    }
}

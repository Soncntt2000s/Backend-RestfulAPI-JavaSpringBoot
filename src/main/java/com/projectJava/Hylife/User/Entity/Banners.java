package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "banners")
@Getter
@Setter
public class Banners extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @Column(name = "title",columnDefinition = "varchar(255)")
    @NotNull
    private String title;

    @Column(name = "content",columnDefinition = "varchar(255)")
    @NotNull
    private String content;

    @Column(name = "url_img",columnDefinition = "varchar(255)")
    @NotNull
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

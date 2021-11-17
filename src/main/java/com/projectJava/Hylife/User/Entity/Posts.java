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
@Table(name = "posts")
@Getter
@Setter
public class Posts extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private int id;

    @ManyToOne
    @JoinColumn(name = "catagory_id",referencedColumnName = "id",columnDefinition = "int(11)")
    @NotNull
    private Catagories catagories;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",columnDefinition = "int(11)")
    @NotNull
    private Users users;

    @Column(name = "view_number",columnDefinition = "int(11) default 0")
    @NotNull
    private Integer viewNumber;

    @Column(name = "like_number",columnDefinition = "int(11) default 0")
    @NotNull
    private Integer likeNumber;

    @Column(name = "title",columnDefinition = "varchar(255)")
    @NotNull
    private String title;

    @Column(name = "url_image",columnDefinition = "varchar(255)")
    @NotNull
    private String url_image;

    @Column(name = "content",columnDefinition = "text")
    @NotNull
    private TextArea content;

    @Column(name = "mini_text",columnDefinition = "varchar(255)")
    @NotNull
    private String mini_text;

    public Posts(Catagories catagories, Users users, Integer viewNumber,
                 Integer likeNumber, String title, String url_image, TextArea content, String mini_text) {
        this.catagories = catagories;
        this.users = users;
        this.viewNumber = viewNumber;
        this.likeNumber = likeNumber;
        this.title = title;
        this.url_image = url_image;
        this.content = content;
        this.mini_text = mini_text;
    }

    public Posts() {
    }
}

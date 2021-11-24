package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Posts extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "catagory_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Catagories catagories;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Users users;

    @Column(name = "view_number",columnDefinition = "int(11) default 0")
    private Integer viewNumber;

    @Column(name = "like_number",columnDefinition = "int(11) default 0")
    private Integer likeNumber;

    @Column(name = "title",columnDefinition = "varchar(255)")
    private String title;

    @Column(name = "url_image",columnDefinition = "varchar(255)")
    private String urlImage;

    @Column(name = "content",columnDefinition = "text")
    private TextArea content;

    @Column(name = "mini_text",columnDefinition = "varchar(255)")
    private String miniText;

    public Posts(Catagories catagories, Users users, Integer viewNumber,
                 Integer likeNumber, String title, String urlImage, TextArea content, String miniText) {
        this.catagories = catagories;
        this.users = users;
        this.viewNumber = viewNumber;
        this.likeNumber = likeNumber;
        this.title = title;
        this.urlImage = urlImage;
        this.content = content;
        this.miniText = miniText;
    }

    public Posts() {
    }
}

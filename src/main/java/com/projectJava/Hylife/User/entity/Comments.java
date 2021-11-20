package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comments extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",columnDefinition = "int(11)")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id",columnDefinition = "int(11)")
    @NotNull
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "comment_parent_id",referencedColumnName = "id",columnDefinition = "int(11)")
    @NotNull
    private Comments comments;

    @Column(name = "like_number",columnDefinition = "int(11) default 0")
    private Integer likeNumber;

    @Column(name = "comment_content",columnDefinition = "text")
    @NotNull
    private TextArea comment_content;


    public Comments(Integer id, Users users, Posts posts,
                    Comments comments, Integer likeNumber, TextArea comment_content) {
        this.id = id;
        this.users = users;
        this.posts = posts;
        this.comments = comments;
        this.likeNumber = likeNumber;
        this.comment_content = comment_content;
    }

    public Comments() {
    }

}

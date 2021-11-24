package com.projectJava.Hylife.User.response;

import com.projectJava.Hylife.User.entity.Catagories;
import com.projectJava.Hylife.User.entity.Users;
import javafx.scene.text.Text;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PostResponce {

    private Catagories catagories;
    private Users users;
    private String title;
    private Text content;
    private String urlImage;
    private Integer viewNumber;
    private Integer likeNumber;
    private String miniText;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public PostResponce(Catagories catagories, Users users, String title, Text content,
                        String urlImage, Integer viewNumber, Integer likeNumber, String miniText,
                        Timestamp createdAt, Timestamp updatedAt) {
        this.catagories = catagories;
        this.users = users;
        this.title = title;
        this.content = content;
        this.urlImage = urlImage;
        this.viewNumber = viewNumber;
        this.likeNumber = likeNumber;
        this.miniText = miniText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PostResponce() {
    }


}

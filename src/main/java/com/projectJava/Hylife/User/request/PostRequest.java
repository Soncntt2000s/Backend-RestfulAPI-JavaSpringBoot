package com.projectJava.Hylife.User.request;

import javafx.scene.text.Text;

public class PostRequest {

    private Integer id;
    private String catagory;
    private String accessToken;
    private Integer viewNumber;
    private Integer likeNumber;
    private String title;
    private String urlImage;
    private Text content;
    private String miniText;

    public PostRequest(Integer id, String catagory, String accessToken, Integer viewNumber,
                       Integer likeNumber, String title, String urlImage, Text content,
                       String miniText) {
        this.id = id;
        this.catagory = catagory;
        this.accessToken = accessToken;
        this.viewNumber = viewNumber;
        this.likeNumber = likeNumber;
        this.title = title;
        this.urlImage = urlImage;
        this.content = content;
        this.miniText = miniText;
    }

    public PostRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }

    public String getMiniText() {
        return miniText;
    }

    public void setMiniText(String miniText) {
        this.miniText = miniText;
    }
}

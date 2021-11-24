package com.projectJava.Hylife.User.request;

import org.hibernate.loader.custom.ScalarReturn;

import java.sql.Timestamp;

public class BannerRequest {

    private String title;
    private String content;
    private String imgImage;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BannerRequest(String title, String content, String imgImage,Timestamp createdAt) {
        this.title = title;
        this.content = content;
        this.imgImage = imgImage;
        this.createdAt = createdAt;
    }

    public BannerRequest(String title, String content, String imgImage,Timestamp createdAt,Timestamp updateAt) {
        this.title = title;
        this.content = content;
        this.imgImage = imgImage;
        this.createdAt = createdAt;
        this.updatedAt = updateAt;
    }

    public BannerRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgImage() {
        return imgImage;
    }

    public void setImgImage(String imgImage) {
        this.imgImage = imgImage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

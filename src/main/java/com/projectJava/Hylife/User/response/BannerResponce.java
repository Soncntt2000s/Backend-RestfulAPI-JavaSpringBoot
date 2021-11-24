package com.projectJava.Hylife.User.response;

import lombok.Data;

@Data
public class BannerResponce {

    private String messageResponce;
    private Long statusCode;
    private String title;
    private String content;
    private String imaImage;

    public BannerResponce(String messageResponce, Long statusCode,
                          String title, String content, String imaImage) {
        this.messageResponce = messageResponce;
        this.statusCode = statusCode;
        this.title = title;
        this.content = content;
        this.imaImage = imaImage;
    }

    public BannerResponce(Long statusCode ,String messageResponce ) {
        this.messageResponce = messageResponce;
        this.statusCode = statusCode;
    }

    public BannerResponce() {
    }
}

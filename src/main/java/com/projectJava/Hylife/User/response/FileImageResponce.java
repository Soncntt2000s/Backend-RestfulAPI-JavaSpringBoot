package com.projectJava.Hylife.User.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class FileImageResponce {

    private String name;
    private String url;
    private String type;
    private long size;


    public FileImageResponce(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
}

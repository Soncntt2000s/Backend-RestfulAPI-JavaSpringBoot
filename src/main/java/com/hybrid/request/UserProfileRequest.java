package com.hybrid.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserProfileRequest {

    private String accessToken;
    private String fullName;
    private Timestamp birthday;
    private int publicStatic;
    private String facebook;
    private String numberPhone;
    private int gender;
    private String branches;
    private String departments;
    private String positions;
    private String description;
    private String nameImage;
    private Timestamp updatedAt;

    public UserProfileRequest(String accessToken, String fullName, int publicStatic,Timestamp birthday,
                              String facebook,  int gender, String branches,String numberPhone,String description,
                              String departments, String positions,Timestamp updatedAt,String nameImage)
    {
        this.accessToken = accessToken;
        this.fullName = fullName;
        this.publicStatic = publicStatic;
        this.birthday = birthday;
        this.facebook = facebook;
        this.gender = gender;
        this.branches = branches;
        this.numberPhone = numberPhone;
        this.description = description;
        this.departments = departments;
        this.positions = positions;
        this.updatedAt = updatedAt;
        this.nameImage = nameImage;
    }

}

package com.projectJava.Hylife.User.request;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;

public class UserProfileRequest {

    private String accessToken;
    private String fullName;
    private Timestamp birthday;
    private Boolean publicStatic;
    private String facebook;
    private String numberPhone;
    private Boolean gender;
    private String branches;
    private String departments;
    private String positions;
    private String description;
    private String nameImage;
    private Timestamp updatedAt;

    public UserProfileRequest(String accessToken, String fullName, Boolean publicStatic,Timestamp birthday,
                              String facebook,  Boolean gender, String branches,String numberPhone,String description,
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

    public UserProfileRequest() {
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public Boolean getPublicStatic() {
        return publicStatic;
    }

    public void setPublicStatic(Boolean publicStatic) {
        this.publicStatic = publicStatic;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

}

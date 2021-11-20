package com.projectJava.Hylife.User.response;

import lombok.Data;

import java.awt.*;
import java.util.Date;
import java.util.List;
@Data
public class UserProfileResponce {

    private Long responseCode;
    private String token;
    private String message;
    private String type = "Bearer";
    private List<String> position;
    private List<String> department;
    private List<String> branch;
    private String numberPhone;
    private String fullName;
    private Date birthday;
    private Boolean publicStatic;
    private String facebook;
    private Boolean gender;
    private TextArea description;

    public UserProfileResponce(Long responseCode, String token, String message, String type,
                              List<String> position, List<String> department, List<String> branch,
                              String numberPhone, String fullName, Date birthday, Boolean publicStatic,
                              String facebook, Boolean gender, TextArea description) {
        this.responseCode = responseCode;
        this.token = token;
        this.message = message;
        this.type = type;
        this.position = position;
        this.department = department;
        this.branch = branch;
        this.numberPhone = numberPhone;
        this.fullName = fullName;
        this.birthday = birthday;
        this.publicStatic = publicStatic;
        this.facebook = facebook;
        this.gender = gender;
        this.description = description;
    }

    public UserProfileResponce() {
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public List<String> getBranch() {
        return branch;
    }

    public void setBranch(List<String> branch) {
        this.branch = branch;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }
}

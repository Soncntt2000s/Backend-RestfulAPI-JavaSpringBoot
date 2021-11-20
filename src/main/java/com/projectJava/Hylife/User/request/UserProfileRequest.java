package com.projectJava.Hylife.User.request;

import com.projectJava.Hylife.User.entity.Branchs;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class UserProfileRequest {

    private String accessToken;
    private String fullName;
    private LocalDate birthday;
    private Boolean publicStatic;
    private String facebook;
    private String numberPhone;
    private Boolean gender;
    private Set<String> branchs;
    private Set<String> departments;
    private Set<String> positions;
    private TextArea description;

    public UserProfileRequest(String accessToken, String fullName, LocalDate birthday, Boolean publicStatic,
                              String facebook, String numberPhone, Boolean gender, Set<String> branchs,
                              Set<String> departments, Set<String> positions, TextArea description)
    {
        this.accessToken = accessToken;
        this.fullName = fullName;
        this.birthday = birthday;
        this.publicStatic = publicStatic;
        this.facebook = facebook;
        this.numberPhone = numberPhone;
        this.gender = gender;
        this.branchs = branchs;
        this.departments = departments;
        this.positions = positions;
        this.description = description;
    }

    public UserProfileRequest() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Set<String> getBranchs() {
        return branchs;
    }

    public void setBranchs(Set<String> branchs) {
        this.branchs = branchs;
    }

    public Set<String> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<String> departments) {
        this.departments = departments;
    }

    public Set<String> getPositions() {
        return positions;
    }

    public void setPositions(Set<String> positions) {
        this.positions = positions;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }
}

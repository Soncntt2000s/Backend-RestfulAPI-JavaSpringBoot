package com.hybrid.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Timestamp;
import java.util.Set;



@Data
public class UserRequest {
    private Integer userId;
    private int status;
    private String email;
    private String password;
    private String loginToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Set<String> role;


    public UserRequest(int status, String email, String password, String loginToken, Timestamp createdAt, Timestamp updatedAt, Set<String> role) {

        this.status = status;
        this.email = email;
        this.password = password;
        this.loginToken = loginToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    @JsonProperty("status")
    public int isStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("login_token")
    public String getLoginToken() {
        return loginToken;
    }

    @JsonProperty("login_token")
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @JsonProperty("created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("role")
    public Set<String> getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(Set<String> role) {
        this.role = role;
    }
}


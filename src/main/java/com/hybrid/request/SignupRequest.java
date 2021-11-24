package com.hybrid.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {

    private String email;
    private String password;
    private Set<String> role;
    private Timestamp createdAt;
    private Boolean status;

    public SignupRequest(String email, String password, Boolean status, Set<String> role, Timestamp createdAt) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.status = status;
    }

}

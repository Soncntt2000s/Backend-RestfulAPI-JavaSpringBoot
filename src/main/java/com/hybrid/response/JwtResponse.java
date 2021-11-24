package com.hybrid.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {

    private Long responseCode;
    private String token;
    private String message;
    private Integer id;
    private String type = "Bearer";
    private List<String> roles;

    public JwtResponse(String accessToken, Long responseCode,String message,Integer id, List<String> roles) {
        this.token = accessToken;
        this.responseCode = responseCode;
        this.message = message;
        this.id = id;
        this.roles = roles;
    }

}

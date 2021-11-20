package com.projectJava.Hylife.User.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MessageResponse {

    private String message;

    @JsonIgnore
    private Integer responseCode;

    public MessageResponse(String message,Integer responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}

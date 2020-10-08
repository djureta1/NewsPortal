package com.example.demo.dto;

import com.sun.istack.NotNull;

public class LoginResponse {

    private Boolean success;

    @NotNull
    private String message;

    private Integer userId;

    public LoginResponse(Boolean success, String message, Integer userId) {
        this.success = success;
        this.message = message;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

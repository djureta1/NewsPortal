package com.example.demo.dto;

import com.sun.istack.NotNull;

public class LoginResponse {

    private Boolean success;

    @NotNull
    private String message;

    public LoginResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
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

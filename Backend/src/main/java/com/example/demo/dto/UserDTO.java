package com.example.demo.dto;

import com.sun.istack.NotNull;

import javax.persistence.Id;

public class UserDTO {


    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @Id
    private Integer roleId;

    public UserDTO(String username, String password, String first_name, String last_name, Integer roleId) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}

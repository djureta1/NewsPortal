package com.example.demo.dto;

import com.sun.istack.NotNull;

public class UserRoleDTO {

    @NotNull
    Integer roleId;

    public UserRoleDTO() {}

    public UserRoleDTO(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

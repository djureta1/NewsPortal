package com.example.demo.dto;

import com.sun.istack.NotNull;

public class RoleDTO {

    @NotNull
    private String roleName;

    public RoleDTO() {}

    public RoleDTO(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

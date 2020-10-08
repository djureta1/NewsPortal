package com.example.demo.controller;

import com.example.demo.dto.RoleDTO;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    Role addRole(@RequestBody RoleDTO role) {
        return roleService.addNewRole(role);
    }

    @DeleteMapping("/role/{id}")
    void deleteRole(@PathVariable Integer id) throws Exception {
        roleService.deleteRolebyId(id);
    }

    @GetMapping("/role/all")
    List<Role> allRoles() {
        return roleService.getAllRoles();
    }
}

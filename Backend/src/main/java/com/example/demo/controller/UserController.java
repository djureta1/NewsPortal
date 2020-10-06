package com.example.demo.controller;

import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserLoginDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    User addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PostMapping("/login")
    LoginResponse login(@RequestBody UserLoginDTO userLoginDTO){
        return userService.login(userLoginDTO);
    }

    @DeleteMapping("/user/{id}")
    void deleteService(@PathVariable Integer id) throws Exception {
        userService.deleteUserById(id);
    }

    @GetMapping("/user/all")
    List<User> allUsers() throws Exception {
        return userService.getAllUsers();
    }

}

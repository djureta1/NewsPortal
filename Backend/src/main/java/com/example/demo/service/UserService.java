package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public List<User> getAllUsers() throws Exception{
        if(userRepository.count()==0) {
            throw new Exception("The base is empty.");
        }
        List<User> allusers=new ArrayList<>();
        userRepository.findAll().forEach(allusers::add);
        return allusers;
    }

    public User addUser(UserDTO userDTO){
        Role role=roleRepository.findById(userDTO.getRoleId()).get();
        User user=new User(userDTO.getUsername(),userDTO.getPassword(),userDTO.getFirst_name(),userDTO.getLast_name(),role);
        return userRepository.save(user);
    }

    public LoginResponse login(UserLoginDTO userLoginDTO) {
        User user=userRepository.findByUsername(userLoginDTO.getUsername());

        if(user.getPassword()==userLoginDTO.getPassword()){
            return new LoginResponse(true,"Loged in");
        }
        return new LoginResponse(false,"Login failed.");
    }

    public void deleteUserById(Integer id) throws Exception{
        if(!userRepository.existsById(id)){
            throw new Exception("User with ID "+id+" do not exist");
        }
        userRepository.deleteById(id);
    }

}

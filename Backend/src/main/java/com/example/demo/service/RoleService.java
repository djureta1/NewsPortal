package com.example.demo.service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role addNewRole(RoleDTO role){
        return roleRepository.save(new Role(role.getRoleName()));
    }

    public List<Role> getAllRoles(){
        List<Role> allRoles=new ArrayList<>();
        roleRepository.findAll().forEach(allRoles::add);
        return allRoles;
    }

    public void deleteRolebyId(Integer id) throws Exception{
        if(!roleRepository.existsById(id)){
            throw new Exception("Role with ID "+id+" do not exist.");
        }
        roleRepository.deleteById(id);
    }


}

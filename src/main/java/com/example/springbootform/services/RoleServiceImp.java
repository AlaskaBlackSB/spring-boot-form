package com.example.springbootform.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootform.models.domain.Role;

@Service
public class RoleServiceImp implements RoleService {

    public List<Role> roles;

    public RoleServiceImp() {
        this.roles = new ArrayList<Role>();

        this.roles.add(new Role(1, "Administrator", "ROLE_ADMIN"));
        this.roles.add(new Role(2, "User", "ROLE_USER"));
        this.roles.add(new Role(3, "Moderator", "ROLE_MODERATOR"));
    }

    @Override
    public List<Role> all() {
        return this.roles;
    }

    @Override
    public Role find(Integer id) {

        for (Role role : roles) {
            if (role.getId() == id) {
                return role;
            }
        }

        return null;
    }

}
package com.example.springbootform.services;

import java.util.List;

import com.example.springbootform.models.domain.Role;

public interface RoleService {

    public List<Role> all();

    public Role find(Integer id);

}
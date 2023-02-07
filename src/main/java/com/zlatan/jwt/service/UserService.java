package com.zlatan.jwt.service;

import com.zlatan.jwt.entity.Role;
import com.zlatan.jwt.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getAllUser();
}

package com.example.demo.service;

import com.example.demo.model.user.User;

public interface UserService {
    void registerUser(String name, String nickname, int age);
    User getUserById(String id);

}

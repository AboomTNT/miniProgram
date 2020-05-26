package com.example.miniprogram.service;

import com.example.miniprogram.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUsers();
    String genderById(long id);
    int updateUser(User user);
    User selectContact(String id);
    User selectUserInfoById(long id);
}

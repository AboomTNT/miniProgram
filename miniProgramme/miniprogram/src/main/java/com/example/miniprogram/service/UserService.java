package com.example.miniprogram.service;

import com.example.miniprogram.entity.User;

import java.util.List;

public interface UserService {
    public List<User> selectAllUsers();
    public String genderById(long id);
    public int selectUserById(long id);
    public int updateUser(User user);
    public User selectContact(String id);
}

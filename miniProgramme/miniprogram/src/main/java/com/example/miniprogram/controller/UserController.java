package com.example.miniprogram.controller;

import com.example.miniprogram.entity.User;
import com.example.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/selectAllUsers")
    //List返回给前端的数据类型
    public List<User> selectAllUsers(){
        return userService.selectAllUsers();
    }
    @GetMapping("/genderById")
    public String genderById(){
        return userService.genderById();
    }
    @GetMapping("/userById")
    public  User selectUserById(long id){
        return  userService.selectUserById(id);
    }
    @GetMapping("/updateUser")
    public int updateUser(@RequestParam("updateUser") User user){
        return userService.updateUser(user);
    }
}

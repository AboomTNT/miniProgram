package com.example.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(HttpServletRequest request,String id){
        String sessionId = request.getSession().getId();
        request.getSession().setAttribute("id",id);
        System.out.println(sessionId);
        return sessionId;
    }
    @GetMapping("/selectContact")
    public String selectContact(HttpServletRequest request){
        String id=request.getSession().getAttribute("id").toString();
        System.out.println(id);
        System.out.println(JSON.toJSONString(userService.selectContact(id)));
        return  JSON.toJSONString(userService.selectContact(id));

    }
    @GetMapping("/selectAllUsers")
    //List返回给前端的数据类型
    public List<User> selectAllUsers(){
        return userService.selectAllUsers();
    }
    @GetMapping("/genderById")
    public String genderById(long id){
        return userService.genderById(id);
    }
    @GetMapping("/userById")
    public  int selectUserById(long openid){
        return  userService.selectUserById(openid);
    }
    @GetMapping("/updateUser")
    public int updateUser(@RequestParam("updateUser") User user){
        return userService.updateUser(user);
    }
}

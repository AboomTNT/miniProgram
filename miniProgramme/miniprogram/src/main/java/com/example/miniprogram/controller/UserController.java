package com.example.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.entity.Works;
import com.example.miniprogram.service.DynamicService;
import com.example.miniprogram.service.FollowService;
import com.example.miniprogram.service.UserService;
import com.example.miniprogram.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DynamicService dynamicService;

    @Autowired
    private WorkService workService;

    @Autowired
    private FollowService followService;
    @GetMapping("/login")
    public String login(HttpServletRequest request,String id){
        String sessionId = request.getSession().getId();
        request.getSession().setAttribute("id",id);
        System.out.println(sessionId);
        return sessionId;
    }
    @GetMapping("/selectContact")
    public String selectContact(HttpServletRequest request){
        String id;
        Object object = request.getSession().getAttribute("id");
        if(object==null){
            id = request.getParameter("id");
    }else {
        id = request.getSession().getAttribute("id").toString();
    }

        System.out.println(id);
        System.out.println(JSON.toJSONString(userService.selectContact(id)));
        return  JSON.toJSONString(userService.selectContact(id));

    }
    @GetMapping("/selectLoginUser")
    public String selectLoginUser(HttpServletRequest request){
        String id = request.getSession().getAttribute("id").toString();
        User user=userService.selectUserInfoById(Long.parseLong(id));
        int follow = followService.selectFollowById(Long.parseLong(id));
        int followed = followService.selectFollowedById(Long.parseLong(id));
        HashMap<String,Object> data = new HashMap<>();
        data.put("user",user);
        data.put("follow",follow);
        data.put("followed",followed);
        return JSON.toJSONString(data);
    }
    @PostMapping("/updateUser")
    public int updateUser(@RequestParam("user") String user,HttpServletRequest request){
        String id = request.getSession().getAttribute("id").toString();
        JSONObject user1 = JSON.parseObject(user);
        return userService.updateUser(user1,id);
    }
    @GetMapping("/userInfoById")
    public String selectUserInfoById(HttpServletRequest request){
        String userId = request.getParameter("userId");
        User user = userService.selectUserInfoById(Long.parseLong(userId));
        List<Dynamic> dynamics = dynamicService.selectDynamicsByUserId(Long.parseLong(userId));
        List<Works> works =  workService.selectWorksByUserId(Long.parseLong(userId));
        int follow = followService.selectFollowById(Long.parseLong(userId));
        int followed = followService.selectFollowedById(Long.parseLong(userId));
        HashMap<String,Object> data = new HashMap<>();
        data.put("user",user);
        data.put("dynamics",dynamics);
        data.put("works",works);
        data.put("follow",follow);
        data.put("followed",followed);
        return JSON.toJSONString(data);
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

}

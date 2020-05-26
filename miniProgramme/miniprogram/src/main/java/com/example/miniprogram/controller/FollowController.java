package com.example.miniprogram.controller;

import com.example.miniprogram.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;
    @GetMapping("/insertFollow")
    public int insertFollow(HttpServletRequest request){
        String id1 = request.getSession().getAttribute("id").toString();
        String id2 = request.getParameter("id");
        return  followService.insertFollow(Long.parseLong(id1),Long.parseLong(id2));
    }
    @GetMapping("/deleteFollow")
    public int delleteFollow(HttpServletRequest request){
        String id1 = request.getSession().getAttribute("id").toString();
        String id2 = request.getParameter("id");
        return  followService.deleteFollow(Long.parseLong(id1),Long.parseLong(id2));
    }
}

package com.example.miniprogram.controller;

import com.example.miniprogram.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;
    @GetMapping("/insertFollow")
    public int insertFollow(long id1,long id2){
        return  followService.insertFollow(id1,id2);
    }
    @GetMapping("/deleteFollow")
    public int delleteFollow(long id1,long id2){
        return  followService.deleteFollow(id1,id2);
    }
}

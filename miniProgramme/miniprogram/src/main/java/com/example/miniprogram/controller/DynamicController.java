package com.example.miniprogram.controller;

import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.service.DynamicService;
import com.example.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/selectAllDynamics")
    //List返回给前端的数据类型
    //显示所有动态
    public List<Dynamic> selectAllDynamics(){
        return dynamicService.selectAllDynamics();
    }
    //按筛选显示动态
    @GetMapping("/selectDynamicsByTags")
    public List<Dynamic> selectDynamicsByTags(String address, String who, String gender, String style){
        return dynamicService.selectDynamicsByTags(address, who, gender,  style);
    }
    //通过发布者查询动态
    @GetMapping("/selectDynamicByUserId")
    public List<Dynamic> selectDynamicBuUserId(long user_id){
        return dynamicService.selectDynamicsByUserId(user_id);
    }
    //通过ID查询动态
    @GetMapping("/selectDynamicById")
    public Dynamic selectDynamicById(long id){
        return dynamicService.selectDynamicById(id);
    }
    //插入动态
    @GetMapping("/insertDynamic")
    public int insertDynamic(Dynamic dynamic){
        return  dynamicService.insertDynamic(dynamic);
    }
    //删除动态
    @GetMapping("/deleteDynamic")
    public int deleteDynamic(long dynamic_id){
        return dynamicService.deleteDynamic(dynamic_id);
    }
    //按照约拍数对动态排序
    @GetMapping("/orderDynamic")
    public List<Dynamic> orderDynamic(){
        return dynamicService.orderDynamic();
    }
}

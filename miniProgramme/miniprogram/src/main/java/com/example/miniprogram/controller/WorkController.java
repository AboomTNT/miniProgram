package com.example.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Works;
import com.example.miniprogram.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;
    @GetMapping("/insertwork")
    public int insertWork(HttpServletRequest request){
        JSONArray imgArr= JSON.parseArray(request.getParameter("img"));
        JSONObject gallery=JSON.parseObject(request.getParameter("gallery"));
        gallery.put("imgs",imgArr);
        String id=request.getSession().getAttribute("id").toString();
        return workService.insertWork(gallery,imgArr,id);
    }
    @GetMapping("/selectWorkByUserId")
    public List<Works> selectWorkByUserId(long user_id){
        return workService.selectWorksByUserId(user_id);
    }
    @GetMapping("/selectWorkById")
    public Works selectWorkById(long id){
        return workService.selectWorkById(id);
    }
    @GetMapping("/deleteWork")
    public int deleteWorkById(long id){
        return workService.deleteWork(id);
    }
}

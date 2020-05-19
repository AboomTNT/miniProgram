package com.example.miniprogram.controller;

import com.example.miniprogram.entity.Works;
import com.example.miniprogram.service.WorkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {
    private WorkService workService;
    @GetMapping("/insertwork")
    public int insertWork(Works works){
        return workService.insertWork(works);
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

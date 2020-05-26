package com.example.miniprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.DynamicPlus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DynamicService {
    public List<DynamicPlus> selectAllDynamics();

    public List<Dynamic> selectDynamicsByTags(String address, String who, String gender, String style);
    public List<Dynamic> selectDynamicsByUserId(long user_id);
    public Dynamic selectDynamicById(long id);
    public int insertDynamic(JSONObject object,String id);
    public int deleteDynamic(long dynamic_id);
    public List<Dynamic> orderDynamic();
}
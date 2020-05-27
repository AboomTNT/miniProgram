package com.example.miniprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.DynamicPlus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DynamicService {
    List<DynamicPlus> selectAllDynamics();

    List<DynamicPlus> selectDynamicsByTags(String region, String identity, String gender, String style);
    List<Dynamic> selectDynamicsByUserId(long user_id);
    DynamicPlus selectDynamicById(long id);
    int insertDynamic(JSONObject object,String id);
    int deleteDynamic(long dynamic_id);
    List<Dynamic> orderDynamic();
}
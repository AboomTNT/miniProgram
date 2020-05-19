package com.example.miniprogram.service;

import com.example.miniprogram.entity.Dynamic;

import java.util.List;

public interface DynamicService {
    public List<Dynamic> selectAllDynamics();

    public List<Dynamic> selectDynamicsByTags(String address, String who, String gender, String style);
    public List<Dynamic> selectDynamicsByUserId(long user_id);
    public Dynamic selectDynamicById(long id);
    public int insertDynamic(Dynamic dynamic);
    public int deleteDynamic(long dynamic_id);
    public List<Dynamic> orderDynamic();
}
package com.example.miniprogram.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Works;
import org.hibernate.jdbc.Work;

import java.util.List;

public interface WorkService {
    public int insertWork(JSONObject gallery, JSONArray imgArr,String id);
    public int deleteWork(long work_id);
    public List<Works> selectWorksByUserId(long user_id);
    public Works selectWorkById(long id);
}

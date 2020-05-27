package com.example.miniprogram.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.*;
import com.example.miniprogram.mapper.ComplexMapper;
import com.example.miniprogram.mapper.DynamicMapper;
import com.example.miniprogram.mapper.UserMapper;
import com.example.miniprogram.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ComplexMapper complexMapper;
    @Override
    public List<DynamicPlus> selectAllDynamics() {
        List<DynamicPlus> dynamicPlus=complexMapper.selectAllDynamics();
//        DynamicExample example = new DynamicExample();
//        example.createCriteria().andDynamicIdIsNotNull();
//        example.setOrderByClause("dynamic_time DESC");
//        List<Dynamic> dynamics = dynamicMapper.selectByExample(example);
        return dynamicPlus;
    }

    @Override
    public List<DynamicPlus> selectDynamicsByTags(String region, String identity, String gender, String style) {

        return complexMapper.selectDynamicsByTags(region,identity,gender,style);
    }
    @Override
    public List<Dynamic> selectDynamicsByUserId(long user_id){
        DynamicExample example = new DynamicExample();
        DynamicExample.Criteria criteria=example.createCriteria();
        criteria.andDynamicUseridEqualTo(user_id);
        example.setOrderByClause("dynamic_time DESC");
        List<Dynamic> dynamics = dynamicMapper.selectByExample(example);
        System.out.println(dynamics.get(0).getDynamicGender());
        return dynamics;
    }
    @Override
    public DynamicPlus selectDynamicById(long id){
        return complexMapper.selectDynamicById(id);
    }
    @Override
    public int insertDynamic(JSONObject object,String id){
        Dynamic dynamic=new Dynamic();
        dynamic.setDynamicWho(object.getString("identity"));
        dynamic.setDynamicAddress(object.getString("address"));

        JSONArray array = object.getJSONArray("region");
        String region = JSON.toJSONString(array);
        dynamic.setDynamicArea(region);

        dynamic.setDynamicUserid(Long.parseLong(id));
        dynamic.setDynamicFinish(object.getString("finish"));
        dynamic.setDynamicMoney(object.getString("money"));
        dynamic.setDynamicRequire(object.getString("describe"));
        dynamic.setDynamicDate(object.getString("date"));
//        Date utilDate  =new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        dynamic.setDynamicTime( df.format(new Date()));
        JSONArray styleArr=object.getJSONArray("style");
        String style=JSON.toJSONString(styleArr);
        dynamic.setDynamicStyle(style);


        JSONArray imgArr=object.getJSONArray("imgs");
        String imgs=JSON.toJSONString(imgArr);
        dynamic.setDynamicImg(imgs);

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserIdEqualTo(Long.parseLong(id));
        List<User> users=userMapper.selectByExample(userExample);
        dynamic.setDynamicGender(users.get(0).getUserGender());
        return dynamicMapper.insertSelective(dynamic);
    }
    @Override
    public int deleteDynamic(long dynamic_id){
        return dynamicMapper.deleteByPrimaryKey(dynamic_id);
    }
    @Override
    public List<Dynamic> orderDynamic(){
        DynamicExample dynamicExample=new DynamicExample();
        dynamicExample.setOrderByClause("dynamic_num DESC");
        List<Dynamic> dynamics=dynamicMapper.selectByExample(dynamicExample);
        return dynamics;
    }

}

package com.example.miniprogram.service.Impl;

import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.DynamicExample;
import com.example.miniprogram.mapper.DynamicMapper;
import com.example.miniprogram.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Resource
    private DynamicMapper dynamicMapper;

    @Override
    public List<Dynamic> selectAllDynamics() {
        DynamicExample example = new DynamicExample();
        example.createCriteria().andDynamicIdIsNotNull();
        example.setOrderByClause("dynamic_time DESC");
        List<Dynamic> dynamics = dynamicMapper.selectByExample(example);
        System.out.println(dynamics);
        return dynamics;
    }

    @Override
    public List<Dynamic> selectDynamicsByTags(String address, String who, String gender, String style) {
        DynamicExample example = new DynamicExample();
        DynamicExample.Criteria criteria=example.createCriteria();
        if(!("全国").equals(address))
            criteria.andDynamicAreaEqualTo(address);
        if (!("身份".equals(who)))
            criteria.andDynamicWhoEqualTo(who);
        if (!("性别").equals(gender))
            criteria.andDynamicGenderEqualTo(gender);
        if (!("风格").equals(style))
            criteria.andDynamicStyleEqualTo(style);
        example.setOrderByClause("dynamic_time DESC");
        List<Dynamic> dynamics = dynamicMapper.selectByExample(example);
        System.out.println(dynamics.get(0).getDynamicGender());
        return dynamics;
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
    public Dynamic selectDynamicById(long id){
        return dynamicMapper.selectByPrimaryKey(id);
    }
    @Override
    public int insertDynamic(Dynamic dynamic){
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

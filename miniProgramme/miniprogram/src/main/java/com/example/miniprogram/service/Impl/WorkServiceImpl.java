package com.example.miniprogram.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Works;
import com.example.miniprogram.entity.WorksExample;
import com.example.miniprogram.mapper.WorksMapper;
import com.example.miniprogram.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorksMapper worksMapper;
    @Override
    public int insertWork(JSONObject gallery, JSONArray imgArr, String id){
        Works works=new Works();
        works.setWorksUserid(Long.parseLong(id));
        works.setWorksAddress(gallery.getString("address"));
        works.setWorksDescribe(gallery.getString("describe"));
        works.setWorksEquiment(gallery.getString("equipment"));
        works.setWorksGivephoto((gallery.getString("givePhoto")=="true")?1:0);
        JSONArray styleArr=gallery.getJSONArray("style");
        String style= JSON.toJSONString(styleArr);
        works.setWorksStyle(style);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        works.setWorksTime( df.format(new Date()));
        String imgs=JSON.toJSONString(imgArr);
        works.setWorksImg(imgs);
        return worksMapper.insertSelective(works);
    }
    @Override
    public  int deleteWork(long work_id){
        return worksMapper.deleteByPrimaryKey(work_id);
    }
    @Override
    public List<Works> selectWorksByUserId(long user_id){
        WorksExample worksExample=new WorksExample();
        worksExample.createCriteria().andWorksUseridEqualTo(user_id);
        worksExample.setOrderByClause("works_time DESC");
        return worksMapper.selectByExample(worksExample);
    }
    @Override
    public Works selectWorkById(long id){
        return  worksMapper.selectByPrimaryKey(id);
    }
}
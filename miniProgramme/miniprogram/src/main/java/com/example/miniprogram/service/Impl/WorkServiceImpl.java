package com.example.miniprogram.service.Impl;

import com.example.miniprogram.entity.Works;
import com.example.miniprogram.entity.WorksExample;
import com.example.miniprogram.mapper.WorksMapper;
import com.example.miniprogram.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorksMapper worksMapper;
    @Override
    public int insertWork(Works work){
        return worksMapper.insertSelective(work);
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

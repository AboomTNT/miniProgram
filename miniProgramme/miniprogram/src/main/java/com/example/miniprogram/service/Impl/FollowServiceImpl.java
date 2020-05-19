package com.example.miniprogram.service.Impl;

import com.example.miniprogram.entity.Follow;
import com.example.miniprogram.entity.FollowExample;
import com.example.miniprogram.mapper.FollowMapper;
import com.example.miniprogram.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.processing.FilerException;

@Service
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowMapper followMapper;
    @Override
    public int insertFollow(long id1,long id2){
        Follow follow=new Follow();
        follow.setFollowId(id1);
        follow.setFollowedId(id2);
        return followMapper.insertSelective(follow);
    }
    @Override
    public int deleteFollow(long id1,long id2){
        FollowExample  followExample=new FollowExample();
        followExample.createCriteria().andFollowedIdEqualTo(id2).andFollowIdEqualTo(id1);
        return followMapper.deleteByExample(followExample);
    }
}

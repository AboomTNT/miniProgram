package com.example.miniprogram.service.Impl;

import com.example.miniprogram.entity.User;
import com.example.miniprogram.entity.UserExample;
import com.example.miniprogram.mapper.UserMapper;
import com.example.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> selectAllUsers(){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIsNotNull();
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
        return users;
    }
    @Override
    public String genderById(){
        long id= 1;
        UserExample example=new UserExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<User> users=userMapper.selectByExample(example);
        System.out.println(users.get(0).getUserGender());
        return users.get(0).getUserGender();
    }
    @Override
    public User selectUserById(long id){
        User user=userMapper.selectByPrimaryKey(id);
        System.out.println(user.getUserId());
        return  user;
    }
    @Override
    public int updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
}

package com.example.miniprogram.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.entity.UserExample;
import com.example.miniprogram.mapper.ComplexMapper;
import com.example.miniprogram.mapper.UserMapper;
import com.example.miniprogram.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ComplexMapper complexMapper;
    @Override
    public List<User> selectAllUsers(){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIsNotNull();
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
        return users;
    }
    @Override
    public String genderById(long id){
        return "";
    }

    public User selectUserInfoById(long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(JSONObject user, String id) {
        User user1 = new User();
        user1.setUserName(user.getString("name"));
        user1.setUserAvater(user.getString("img"));
        user1.setUserAddress(user.getString("address"));
        //user1.setUserBirthday(user.getString("bitthday"));
        return 1;
    }

    @Override
    public int updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
    @Override
    public User selectContact(String id){
        //System.out.println(complexMapper.selectContact(id).getUserPhone());
         String phone=complexMapper.selectPhone(id);
         String wx=complexMapper.selectWx(id);
         User user=new User();
        user.setUserWx(wx);
        user.setUserPhone(phone);
        return user;
    }
}

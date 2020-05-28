package com.example.miniprogram.service.Impl;

import com.alibaba.fastjson.JSONArray;
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
    @Override
    public User selectUserInfoById(long id){
        return userMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateUser(JSONObject user,String id){
        User user1 = new User();
        user1.setUserName(user.getString("name"));
        user1.setUserAvater(user.getString("img"));
        JSONArray region = user.getJSONArray("address");
        String address = region.getString(1);
        user1.setUserAddress(address);
        user1.setUserBirthday(user.getString("birthday"));
        user1.setUserGender(user.getString("gender"));
        user1.setUserWx(user.getString("wx"));
        user1.setUserPhone(user.getString("phone"));
        user1.setUserIdentity(user.getString("identity"));
        user1.setUserDescribe(user.getString("describe"));
        user1.setUserId(Long.parseLong(id));
        return userMapper.updateByPrimaryKey(user1);
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

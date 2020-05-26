package com.example.miniprogram.controller;

import antlr.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Dynamic;
import com.example.miniprogram.entity.DynamicPlus;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.service.DynamicService;
import com.example.miniprogram.service.UserService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

@RestController
@RequestMapping(value = "/dynamic")
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/selectAllDynamics")
    //List返回给前端的数据类型
    //显示所有动态
    public String selectAllDynamics(){
        HashMap<String,Object> data = new HashMap<>();
        List<DynamicPlus> dynamicList = dynamicService.selectAllDynamics();
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(dynamicList));
        //String data=StringEscapeUtils.unescapeJavaScript(JSON.toJSONString(dynamicList));
        data.put("dynamicList",array);
        //System.out.print(dynamicService.selectAllDynamics());
        return JSON.toJSONString(data);
    }
    //按筛选显示动态
    @GetMapping("/selectDynamicsByTags")
    public List<Dynamic> selectDynamicsByTags(String address, String who, String gender, String style){
        return dynamicService.selectDynamicsByTags(address, who, gender,  style);
    }
    //通过发布者查询动态
    @GetMapping("/selectDynamicByUserId")
    public List<Dynamic> selectDynamicBuUserId(long user_id){
        return dynamicService.selectDynamicsByUserId(user_id);
    }
    //通过ID查询动态
    @GetMapping("/selectDynamicById")
    public Dynamic selectDynamicById(long id){
        return dynamicService.selectDynamicById(id);
    }
    //插入动态
    @GetMapping("/insertDynamic")
    public int insertDynamic(HttpServletRequest request){
//        System.out.println(request.getParameter("formdata"));
        JSONArray imgs = JSON.parseArray(request.getParameter("img"));
        JSONObject data= JSON.parseObject(request.getParameter("dynamic"));
        data.put("imgs",imgs);
        System.out.print(request.getSession().getId());
        String id=request.getSession().getAttribute("id").toString();
        return dynamicService.insertDynamic(data,id);
//        Dynamic dynamic=new Dynamic();
//        dynamic.setDynamicWho(request.getParameter(""));
//        return  dynamicService.insertDynamic(dynamic);
    }
    //删除动态
    @GetMapping("/deleteDynamic")
    public int deleteDynamic(long dynamic_id){
        return dynamicService.deleteDynamic(dynamic_id);
    }
    //按照约拍数对动态排序
    @GetMapping("/orderDynamic")
    public List<Dynamic> orderDynamic(){
        return dynamicService.orderDynamic();
    }
    //接收图片
    @PostMapping("/uploadFiles")
    public String uploadPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        //对应前端的upload的name参数"file"
        MultipartFile multipartFile = req.getFile("img");

        //realPath填写电脑文件夹路径
        String realPath = "D:\\miniProgramme\\miniprogram\\src\\main\\resources\\static\\images";

        //裁剪用户id
        String originalFirstName = multipartFile.getOriginalFilename();

        //String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));
        String[] pics=originalFirstName.split("\\.");
        String picFirstName =pics[pics.length-2];
        //取得图片的格式后缀
        String originalLastName = multipartFile.getOriginalFilename();

        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //拼接：名字+后缀
        String picName = picFirstName  + picLastName;
        try {
            File dir = new File(realPath);
            //如果文件目录不存在，创建文件目录
            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("创建文件目录成功：" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            System.out.println("接收图片成功！");
        } //catch (IOException e) {
            //e.printStackTrace();
        //}
        catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return picName;
    }
}

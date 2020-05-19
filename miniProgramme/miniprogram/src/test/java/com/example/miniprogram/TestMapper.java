package com.example.miniprogram;

import com.example.miniprogram.entity.User;
import com.example.miniprogram.entity.UserExample;
import com.example.miniprogram.mapper.UserMapper;
import com.example.miniprogram.service.DynamicService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@MapperScan("com.example.miniprogram.mapper")

public class TestMapper {
    @Autowired
    DynamicService dynamicService;
    @Test
    void contextLoads() {
        dynamicService.selectDynamicsByTags("贵阳","摄影师","男","风格");
    }

}

/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.service
 * @className com.thunisoft.demo.PageNavigationSystem.service.LjxxService
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.artery.util.uuid.UUIDHelper;
import com.thunisoft.demo.PageNavigationSystem.mapper.LjxxMapper;
import com.thunisoft.demo.PageNavigationSystem.model.Ljxx;

/**
 * 文章表service接口实现类
 * 
 * @description 文章表service接口实现
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@Service
@Slf4j
public class LjxxService{

    /**
     * ljxxMapper
     */
    @Autowired
    private LjxxMapper ljxxMapper;

    /**
     * LjxxService
     * 
     * @description 插入一条文章表数据
     * @param ljxx 文章表
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public int insert(Ljxx ljxx) {
        if (StringUtils.isBlank(ljxx.getBh())) {
            ljxx.setBh(UUIDHelper.getUuid());
        }
        return ljxxMapper.insert(ljxx);
    }

    /**
     * LjxxService
     * 
     * @description 通过主键删除文章表数据
     * @param cbh 主键编号
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public int delete(String cbh) {
        return ljxxMapper.deleteByPrimaryKey(cbh);
    }

    /**
     * LjxxService
     * 
     * @description 通过主键修改Ljxx数据
     * @param ljxx 更新实体
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public int update(Ljxx ljxx) {
        //updateByPrimaryKeySelective：为null的字段不会受影响
        //updateByPrimaryKey：字段为null时，会将数据库对应字段置空
        return ljxxMapper.updateByPrimaryKeySelective(ljxx);
    }

    /**
     * LjxxService
     * 
     * @description 查询所有数据
     * @return List<Ljxx>
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public List<Ljxx> selectAll() {
        return ljxxMapper.selectAll();
    }

    /**
     * LjxxService
     * 
     * @description 通过条件查询多条数据
     * @param args 参数
     * @return List<Ljxx>
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public List<Ljxx> select(Ljxx args) {
        return ljxxMapper.select(args);
    }

    /**
     * LjxxService
     * 
     * @description 通过主键查询文章表信息
     * @param cbh 主键编号
     * @return Ljxx
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    public Ljxx selectOne(String cbh) {
        return ljxxMapper.selectByPrimaryKey(cbh);
    }
}
/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.controller
 * @className com.thunisoft.demo.PageNavigationSystem.controller.LjxxController
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thunisoft.artery.data.QueryManager;
import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.artery.data.model.ArteryPageableData;
import com.thunisoft.artery.data.model.IQueryInfo;
import com.thunisoft.demo.PageNavigationSystem.model.Ljxx;
import com.thunisoft.demo.PageNavigationSystem.service.LjxxService;
import com.thunisoft.demo.PageNavigationSystem.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * LjxxController
 * 
 * @description 路径信息表
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@Api(value = "路径信息表", tags = "路径信息表")
@RequestMapping(value = "/api/v1")
@RestController
public class LjxxController {

    /**
     * ljxxService
     */
    @Autowired
    private LjxxService ljxxService;

    /**
     * 
     * LjxxController
     * 
     * @description 创建路径信息表
     * @param ljxx 路径信息表
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @ApiOperation(value = "创建路径信息表", response = Integer.class)
    @PostMapping(value = "/ljxx", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insert(@Validated({Validate.class}) @RequestBody Ljxx ljxx) {
        Integer count = 0;
        if(ljxx.getBh() == null){
            count = ljxxService.insert(ljxx);
        }else {
            count = ljxxService.update(ljxx)+2;
        }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * LjxxController
     * 
     * @description 删除路径信息表
     * @param id 主键
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @ApiOperation(value = "删除路径信息表", response = Integer.class)
    @DeleteMapping(value = "/ljxx/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> delete(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Integer count = ljxxService.delete(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * LjxxController
     * 
     * @description 修改路径信息表
     * @param ljxx 路径信息表
     * @return 影响行数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @ApiOperation(value = "修改路径信息表", response = Integer.class)
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> update(@Validated({Validate.class}) @RequestBody Ljxx ljxx) {
        Integer count = ljxxService.update(ljxx);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * LjxxController
     * 
     * @description 分页查询路径信息表
     * @param info 查询条件
     * @return PageBeanVO<Ljxx>
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @ApiOperation(value = "分页查询路径信息表", response = Ljxx.class)
    @PostMapping(value = "/ljxx/page", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<ArteryPageableData<List<Ljxx>>> selectAll(IQueryInfo info) {
        ArteryPageableData<List<Ljxx>> pageData = QueryManager.datas(info, Ljxx.class, ljxxService::selectAll);
        return new ResponseEntity<>(pageData, HttpStatus.OK);
    }

    /**
     * 
     * LjxxController
     * 
     * @description 查询路径信息表
     * @param id 主键
     * @return Ljxx
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @ApiOperation(value = "查询路径信息表", response = Ljxx.class)
    @GetMapping(value = "/ljxx/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<Ljxx> selectOne(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Ljxx result = ljxxService.selectOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/addForm")
    public String addForm (){
        return "addForm";
    }
}
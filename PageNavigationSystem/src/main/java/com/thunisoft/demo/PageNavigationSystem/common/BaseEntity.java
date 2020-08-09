/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.common
 * @className com.thunisoft.demo.PageNavigationSystem.common.BaseEntity
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import com.thunisoft.demo.PageNavigationSystem.validate.Validate;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * BaseEntity
 *
 * @description 基础类
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @Column(name = "C_BH")
    @Size(max = 32, groups = {Validate.class}, message = "主键的最大长度为32")
    @Id
    private String bh;

}
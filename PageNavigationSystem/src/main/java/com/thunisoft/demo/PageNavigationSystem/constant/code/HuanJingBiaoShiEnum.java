/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.constant.code
 * @className com.thunisoft.demo.PageNavigationSystem.constant.code.HuanJingBiaoShiEnum
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.constant.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HuanJingBiaoShiEnum
 * @description 环境标识 常量枚举
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 **/
@Getter
@AllArgsConstructor
public enum HuanJingBiaoShiEnum {

    
    /**
     * dev
     */
    DEV("0", "dev"),

    /**
     * feature
     */
    FEATURE("1", "feature"),

    /**
     * release
     */
    RELEASE("2", "release");


    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;
}
/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.constant.code
 * @className com.thunisoft.demo.PageNavigationSystem.constant.code.SuoShuDiQuEnum
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.constant.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SuoShuDiQuEnum
 * @description 所属地区 常量枚举
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 **/
@Getter
@AllArgsConstructor
public enum SuoShuDiQuEnum {

    
    /**
     * 北京
     */
    BEI_JING("0", "北京地区"),

    /**
     * 广州
     */
    GUANG_ZHOU("1", "广州地区"),

    /**
     * 成都
     */
    CHENG_DOU("2", "成都地区"),

    /**
     * 南京
     */
    NAN_JING("3", "南京地区");


    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;
}
/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.dto
 * @className com.thunisoft.demo.PageNavigationSystem.dto.ExampleDTO
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.dto;


import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ExampleDTO
 *
 * @description 案例dto-请删除
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version v1.0
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("示例展示用dto-用于接收前台传入的值")
public class ExampleDTO {

    @ApiModelProperty(value = "案例题的场景描述")
    @NotBlank(message = "案例场景不能为空")
    private String ms;

}
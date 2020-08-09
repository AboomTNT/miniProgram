/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.model
 * @className com.thunisoft.demo.PageNavigationSystem.model.Ljxx
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.model;

import javax.persistence.Column;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.thunisoft.demo.PageNavigationSystem.common.BaseEntity;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import com.thunisoft.demo.PageNavigationSystem.validate.Validate;
import com.thunisoft.artery.data.annotation.CodeType;


/**
 * Ljxx
 *
 * @description 文章表实体
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 **/
@ApiModel("文章表")
@Table(name="DB_YW.T_LJXX")    
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ljxx extends BaseEntity{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 系统名称
     */
    @ApiModelProperty("系统名称")
    @Column(name = "C_XTMC")
    @Size(max = 300, groups = {Validate.class}, message = "系统名称的最大长度为300")
    private String xtmc;

    /**
     * 系统地址
     */
    @ApiModelProperty("系统地址")
    @Column(name = "C_XTDZ")
    @Size(max = 300, groups = {Validate.class}, message = "系统地址的最大长度为300")
    private String xtdz;

    /**
     * 系统说明
     */
    @ApiModelProperty("系统说明")
    @Column(name = "C_XTSM")
    @Size(max = 300, groups = {Validate.class}, message = "系统说明的最大长度为300")
    private String xtsm;

    /**
     * 环境标识
     */
    @ApiModelProperty("环境标识")
    @Column(name = "N_HJBS")
    @CodeType("10001")
    private Integer hjbs;

    /**
     * 所属地区
     */
    @ApiModelProperty("所属地区")
    @Column(name = "N_SSDQ")
    @CodeType("10002")
    private Integer ssdq;

    /**
     * 最后修改方式，1、创建2、修改
     */
    @ApiModelProperty("最后修改方式，1、创建2、修改")
    @Column(name = "N_ZHXGFS")
    private Integer zhxgfs;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Column(name = "C_CJR")
    @Size(max = 300, groups = {Validate.class}, message = "创建人的最大长度为300")
    private String cjr;

    /**
     * 最后修改人
     */
    @ApiModelProperty("最后修改人")
    @Column(name = "C_ZHXGR")
    @Size(max = 300, groups = {Validate.class}, message = "最后修改人的最大长度为300")
    private String zhxgr;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "DT_CJSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cjsj;

    /**
     * 最后修改时间
     */
    @ApiModelProperty("最后修改时间")
    @Column(name = "DT_ZHXGSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime zhxgsj;

}
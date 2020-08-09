/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem
 * @className com.thunisoft.demo.PageNavigationSystem.PageNavigationSystemApplication
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


/**
 *
 * PageNavigationSystemApplication
 *
 * @description PageNavigationSystemApplication
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@EnableCaching
@SpringBootApplication
@MapperScan({"com.thunisoft.demo.PageNavigationSystem"})
public class PageNavigationSystemApplication {

	/**
     * PageNavigationSystemApplication
     *
     * @description 主类
     * @param args 启动参数
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     **/
    public static void main(String[] args) {
    	SpringApplication.run(PageNavigationSystemApplication.class, args);
    }
}
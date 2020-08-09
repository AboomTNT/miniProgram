/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.config
 * @className com.thunisoft.demo.PageNavigationSystem.config.SwaggerConfig
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * 
 * SwaggerConfig
 * 
 * @description SwaggerConfig
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@EnableSwagger2Doc
@Configuration
@Profile({"dev", "test"})
public class SwaggerConfig {

	/**
     * SwaggerConfig
     *
     * @description Swagger api
     * @return Docket
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any()).build();
    }

    /**
     * 
     * SwaggerConfig
     * @description ApiInfo
     * @return ApiInfo
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("页面导航系统").description("应用RestFul Api接口").version("1.0").build();
    }

}
package com.tu.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Classname SwaggerConfig
 * @Date 2019/5/15 16:46
 * @Created by tuyongjian
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 这些不配置，swagger会自动扫描所有包
     * @return
     */

/*    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.tu.swagger.controller"))
                .paths(PathSelectors.any()).build();

    }*/
    //构建api文档的详细信息函数
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("springBoot测试使用Swagger2构建RESTful API")
                //创建人
                .contact(new Contact("tuyongjian","http://localhost:1141",""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
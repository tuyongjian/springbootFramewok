package com.tu.swagger.controller;

import com.tu.swagger.config.RestMessgae;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Classname SwaggerAction
 * @Date 2019/5/15 16:49
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "swagger")
//@Api("swaggerTestController相关api")
public class SwaggerAction {

    /**
     *  @Api()：作用于类上，表示这个类是swagger的资源。
     *   tags = ”说明该类的作用“
     *  @ApiOperation()：用在请求的方法上，说明的方法的用户和作用
     *    value=“说明方法的用途、作用”
     *    notes="方法的备注说明“
     *  @ApiImplicitParams()：用在请求的方法上，表示一组参数说明，可以包含多个@ApiImplicitParam()
     *  @ApiImplicitParam()：指定一个请求参数的各个方面
     *          name：参数名
     *       value：参数的汉字说明
     *       required：参数是否必须传
     *       dataType：参数类型
     *       defaultValue：参数的默认值
     *  @ApiResponses()：用在请求的方法上，表示一组响应。可以包含多个@ApiResponse()
     *  @ApiResponse()：用于表示一个错误的响应信息
     *    code：数字
     *    message：信息
     *    response：抛出异常的类      
     *  @ApiModel()：用在响应类上，表示一个返回响应数据的信息。
     *  @ApiModelProperty()：用在属性上，描述响应类的属性
     */


/*    @ApiOperation(value = "根据id查询学生的信息",notes = "查询数据库中某个学生的信息")
    @ApiImplicitParam(name ="id",value = "学生id",paramType = "path",required = true,dataType = "String")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",dataType = "String",paramType = "query",example = "1112")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = "请求参数没有填好"),
            @ApiResponse(code=404,message="请求路径没有找到")
    })*/
    @GetMapping(value = "testRest")
    public RestMessgae testGetResetful(@RequestParam(value = "id") String id){
        RestMessgae restMessgae = new RestMessgae();
        restMessgae.setData(id);
        return restMessgae;
    }

    @GetMapping(value = "hello")
    public String hello(){
        return "Hello World";
    }
}
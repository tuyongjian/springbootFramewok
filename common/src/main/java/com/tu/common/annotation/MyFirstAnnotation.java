package com.tu.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 自定义注解
 * @Classname MyFirstAnnotation
 * @Date 2019/5/23 14:21
 * @Created by tuyongjian
 *
 * 这四个注解是元注解
 *
 * @Target({ElementType.METHOD, ElementType.TYPE}) 定义注解修饰的目标 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
 * @Retention(RetentionPolicy.RUNTIME) @Retention 定义注解的生命周期 SOURCE 源码级别 CLASS 编译期级别 RUNTIME 运行期级别
 * @Documented 定义注解会被javadoc或者其他类似工具文档化
 * @Inherited 阐述了某个被标注的类型是被继承的
 */
@Target({ElementType.FIELD})//表示这个注解只适用于属性
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFirstAnnotation {

    String color() default "red";
}
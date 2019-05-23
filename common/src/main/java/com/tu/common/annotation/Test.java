package com.tu.common.annotation;

import java.lang.reflect.Field;

/**
 * @Description
 * @Classname Test
 * @Date 2019/5/23 15:03
 * @Created by tuyongjian
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class cla = Class.forName("com.tu.common.annotation.Wintersweet");
        Field[] fields = cla.getDeclaredFields();

        for (Field f: fields) {
            if(f.isAnnotationPresent(MyFirstAnnotation.class)){
                MyFirstAnnotation myFirstAnnotation = f.getAnnotation(MyFirstAnnotation.class);
                System.out.println("梅花的颜色--"+myFirstAnnotation.color());
            }
        }
    }
}
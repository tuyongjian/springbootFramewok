package com.tu.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description  controller 增强器
 * @Classname MyControllerAdvice
 * @Date 2019/5/23 11:29
 * @Created by tuyongjian
 */
@ControllerAdvice
public class MyControllerAdvice {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "tuyongjian");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        Result result = new Result();
        result.setResult("500");
        result.setMessage(ex.getMessage());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public Result myErrorHandler(MyException ex) {
        Result result = new Result();
        result.setResult(ex.getCode());
        result.setMessage(ex.getMsg());
        return result;
    }


}
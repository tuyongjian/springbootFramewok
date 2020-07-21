package com.tu.springsession.controller;

import com.tu.common.MyException;
import com.tu.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Auther: tuyongjian
 * @Date: 2020/7/21 09:35
 * @Description:
 */
@RestController
@RequestMapping(value = "api/user")
public class SpringSessionAction {



    @RequestMapping("/login")
    public Result login(HttpServletRequest request)
    {
        String userId ="123";
        HttpSession session = request.getSession();
        session.setAttribute("loginUserId", userId);
        return new Result(true, "登录成功！");

    }

    @RequestMapping(value = "/getUserInfo")
    public Result get()
    {
        return new Result(true, "查询成功！");
    }

}

package com.tu.curd.mysql;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tu.common.PageResult;
import com.tu.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description
 * @Classname MySqlAction
 * @Date 2019/9/2 15:11
 * @Created by tuyongjian
 */

@Controller
@RequestMapping(value = "mysql")
public class MySqlAction {

    @Autowired
    private IUserService userService;


    @ResponseBody
    @RequestMapping(value = "queryUser",method = RequestMethod.POST)
    public User queryUser(ModelMap model,
                          @RequestParam(value = "id") int id,
                          HttpServletResponse response){
        User user  = this.userService.queryUser(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "queryByPage",method = RequestMethod.GET)
    public Result queryByPage(ModelMap model){

        PageHelper.startPage(1, 3, true);
        List<User> users = this.userService.queryUserByPage();

        PageInfo<User> pageInfo = new PageInfo<User>(users);

        PageResult<User> pageResult = new PageResult<User>();

        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setList(users);


        return new Result(true,"查询成功",pageResult);
    }
}
package com.tu.curdMasterAndSlave.controller;

import com.tu.curdMasterAndSlave.config.SqlMapperFactory;
import com.tu.curdMasterAndSlave.dao.UserDao;
import com.tu.curdMasterAndSlave.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:
 */
@RequestMapping(value = "curdMasterAndSlave")
@RestController
public class CurdMasterAndSlaveAction {

    @ResponseBody
    @RequestMapping(value = "master" ,method = RequestMethod.GET)
    public List<User> master(){
        return SqlMapperFactory.buildMaster(UserDao.class).queryUserByPage();
    }

    @ResponseBody
    @RequestMapping(value = "insert" ,method = RequestMethod.GET)
    public String insert(){
        User user = new User();
        user.setUserName("11");
        user.setRealName("123");
        SqlMapperFactory.buildMaster(UserDao.class).insert(user);
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "slave" ,method = RequestMethod.GET)
    public List<User> slave(){
        return SqlMapperFactory.buildSlave(UserDao.class).queryUserByPage();
    }

    public static void main(String[] args) {
        CurdMasterAndSlaveAction curdMasterAndSlaveAction = new CurdMasterAndSlaveAction();
        curdMasterAndSlaveAction.test(10);

    }

    int test(int a){
        boolean isExist = false;
        int result = 100;
        for (int i = 0; i <a ; i++) {
            if(i==5){
                isExist = true;
                break;
            }else{
                System.out.println(i);
            }
        }
        if(isExist){
            return test(4);
        }else{
            return result;
        }
    }
}

package com.tu.curdMasterAndSlave.dao;

import com.tu.curdMasterAndSlave.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tuyongjian on 2019/1/6.
 */

public interface UserDao {

    User selectUser(int id);

    int insert(User user);

    int update(User user);

    int selectCount();

    int procedure();

    List<User> queryUserByPage();
}

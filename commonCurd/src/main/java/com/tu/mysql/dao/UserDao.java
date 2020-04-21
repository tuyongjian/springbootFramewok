package com.tu.mysql.dao;

import com.tu.mysql.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tuyongjian on 2019/1/6.
 */
@Mapper
@Repository
public interface UserDao {

    User selectUser(int id);

    int insert(User user);

    int update(User user);

    int selectCount();

    int procedure();

    List<User> queryUserByPage();
}

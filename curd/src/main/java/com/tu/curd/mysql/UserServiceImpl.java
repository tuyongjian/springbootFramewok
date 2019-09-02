package com.tu.curd.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuyongjian on 2019/1/6.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public User queryUser(int id) {
        return userDao.selectUser(id);
    }

    public List<User> queryUserByPage() {
        return userDao.queryUserByPage();
    }

    public int addUser(User user) {
        int result = userDao.insert(user);
        return result;
    }

    public int updateUser(User user) {
        int result = userDao.update(user);
        return result;
    }

    public int queryCount() {
        return userDao.selectCount();
    }

    public int procedure() {
        return userDao.procedure();
    }
}

package com.tu.mysql.service;

import com.tu.mysql.dao.UserDao;
import com.tu.mysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:
 */
@Service
public class UseServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(User user) {
        userDao.insert(user);
    }
}

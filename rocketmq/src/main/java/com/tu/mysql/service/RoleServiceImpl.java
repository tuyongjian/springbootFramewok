package com.tu.mysql.service;

import com.tu.mysql.dao.RoleDao;
import com.tu.mysql.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(Role role) {
        roleDao.insert(role);
    }
}

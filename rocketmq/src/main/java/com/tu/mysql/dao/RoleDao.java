package com.tu.mysql.dao;

import com.tu.mysql.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 13:39
 * @Description:
 */
@Mapper
@Repository
public interface RoleDao {

    int insert(Role role);
}

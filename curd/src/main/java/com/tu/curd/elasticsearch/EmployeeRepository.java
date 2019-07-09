package com.tu.curd.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Classname EmployeeRepository
 * @Date 2019/7/9 16:26
 * @Created by tuyongjian
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {


}
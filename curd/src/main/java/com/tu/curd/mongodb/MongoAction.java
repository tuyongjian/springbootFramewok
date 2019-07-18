package com.tu.curd.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname MongoAction
 * @Date 2019/7/18 14:27
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "mongo")
public class MongoAction {

    @Autowired
    MongoTemplate mongotemplate;

    @RequestMapping(value = "add")
    public void add(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setAge(27);
        employee.setFirstName("tt");
        employee.setLastName("tt");
        employee.setAbout("garbage");
        mongotemplate.save(employee);
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public Employee query(@RequestParam(value = "id")String id){
        Query query = new Query(Criteria.where("id").is(id));
        Employee employee = mongotemplate.findOne(query,Employee.class);
        return employee;
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public void update(@RequestParam(value = "id")String id){
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("firstName", "ttt").set("lastName", "ttt");
        mongotemplate.updateFirst(query,update,Employee.class);
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public void delete(@RequestParam(value = "id")String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongotemplate.remove(query,Employee.class);
    }
}
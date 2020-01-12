package com.tu.curdMasterAndSlave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: tuyongjian
 * @Date: 2020/1/7 11:15
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.tu.curdMasterAndSlave"})
public class CurdMasterAndSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurdMasterAndSlaveApplication.class,args);
    }

}

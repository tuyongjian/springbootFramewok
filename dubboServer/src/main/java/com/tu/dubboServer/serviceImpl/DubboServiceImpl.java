package com.tu.dubboServer.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tu.common.service.IDubboService;
import org.springframework.stereotype.Component;

/**
 * @Auther: tuyongjian
 * @Date: 2019/12/6 10:12
 * @Description:
 *
 * @Service 注意这个Service注解，一定是阿里的包
 * 如果引入的spring的包则服务端注解不成功 切记
 * 如果一个接口有多个接口实现可以使用组来实现隔离
 * 这里加了分组test 则调用方也要加组
 *
 */
@Service(group = "test")
@Component
public class DubboServiceImpl implements IDubboService {

    private final Integer total = 100;

    @Override
    public Integer add(int cost) {
        return total+cost;
    }
}

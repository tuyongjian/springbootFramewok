package com.tu.dubboConsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tu.common.service.IDubboService;
import com.tu.dubboConsumer.service.IDubboConsumerService;
import org.springframework.stereotype.Service;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:
 */
@Service
public class DubboConsumerServiceImpl implements IDubboConsumerService {

    /**
     * @Reference 这个注解就是远程调用dubbo的服务端实现接口
     * 指定使用哪个分组的接口
     */

    @Reference(group = "test")
    private IDubboService dubboService;

    @Override
    public String cost(int a) {
        return dubboService.add(a).toString();
    }
}

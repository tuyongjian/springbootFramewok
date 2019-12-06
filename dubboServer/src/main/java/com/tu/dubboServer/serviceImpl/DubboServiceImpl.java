package com.tu.dubboServer.serviceImpl;

import com.tu.common.service.IDubboService;
import org.springframework.stereotype.Service;

/**
 * @Auther: tuyongjian
 * @Date: 2019/12/6 10:12
 * @Description:
 */
@Service
public class DubboServiceImpl implements IDubboService {

    private final Integer total = 100;

    @Override
    public Integer add(int cost) {
        return total+cost;
    }
}

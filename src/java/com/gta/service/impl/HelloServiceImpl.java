package com.gta.service.impl;

import com.gta.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl 功能： HelloService实现类
 * created by ningning.jiang 2017-08-14 13:36:43
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "HelloServiceImpl sayHello method excute";
    }
}

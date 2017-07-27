package com.gta.service.impl;

import com.gta.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 * Created by ningning.jiang on 2017/6/23.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "HelloServiceImpl sayHello method excute";
    }
}

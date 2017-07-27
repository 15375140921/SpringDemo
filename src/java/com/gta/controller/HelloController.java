package com.gta.controller;

import com.gta.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloController -- this is a demo.
 * Created by ningning.jiang on 2017/6/23.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println(helloService.sayHello());
        return "hello";
    }

}

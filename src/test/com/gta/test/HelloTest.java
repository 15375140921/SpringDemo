package com.gta.test;

import com.gta.service.HelloService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello类测试
 * Created by ningning.jiang on 2017/6/23.
 */
public class HelloTest extends BaseTest{

    private static Logger logger = Logger.getLogger(HelloTest.class);

    @Autowired
    private HelloService helloService;

    @Test
    public void testHello(){
        logger.info("testHello method execute");
        System.out.println(helloService.sayHello());
    }

}

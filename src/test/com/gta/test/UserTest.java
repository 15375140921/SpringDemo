package com.gta.test;

import com.gta.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserTest
 * Created by ningning.jiang on 2017/6/26.
 */
public class UserTest extends BaseTest {

    private static Logger logger = Logger.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void testCountUser() {
        logger.info("testCountUser method execute");
        System.out.println(userService.countUser());
    }

    @Test
    public void testListUser() {
        logger.info("testListUser method execute");
        System.out.println(userService.listUser());
    }

    @Test
    public void testGetUserById() {
        logger.info("testGetUserById method execute");
        System.out.println("=======================================");
        System.out.println(userService.getUserById(2).getPassWord());
        System.out.println("=======================================");
    }

}

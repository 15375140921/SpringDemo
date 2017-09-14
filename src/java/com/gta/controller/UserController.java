package com.gta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController
 * Created by ningning.jiang on 2017/7/6.
 */
@Controller
public class UserController {

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/teaManage")
    public String teaManage(){
        return "teaManage";
    }

    @RequestMapping("/tea")
    public String tea(){
        return "tea";
    }

    @RequestMapping("/stu")
    public String stu(){
        return "stu";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "notice";
    }

    @RequestMapping("/teacher")
    public String teacher(){return "tea";}
}

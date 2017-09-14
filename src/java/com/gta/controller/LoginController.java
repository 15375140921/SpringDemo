package com.gta.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * LoginController
 * Created by ningning.jiang on 2017/6/30.
 */
@Controller
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");
        model.addAttribute("list", list);
        model.addAttribute("str", "Hello FreeMarker");
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpSession session, Model model) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        Subject subject = SecurityUtils.getSubject();
        logger.info(subject.isRemembered());
        logger.info(subject.isAuthenticated());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, boolean rememberMe, Model model, HttpSession session) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
        if (rememberMe) {
            upToken.setRememberMe(true);
        }
        Subject subject = SecurityUtils.getSubject();
        String msg = null;
        try {
            subject.login(upToken);
        } catch (AuthenticationException e) {
            msg = e.getMessage();
        }
        if (msg == null) {
            session.setAttribute("currentUser", username);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }


    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}

package com.lu.controller;

import com.lu.model.UserService;
import com.lu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "jsp/success";
    }

    @RequestMapping("/query")
    public ModelAndView QueryUser() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.queryUser();
        System.out.println(userList);
        modelAndView.addObject("list",userList);
        modelAndView.setViewName("jsp/query");
        return modelAndView;
    }
}

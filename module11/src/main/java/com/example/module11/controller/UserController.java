package com.example.module11.controller;

import com.example.module11.entity.User;
import com.example.module11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("showAllUsers");
        return modelAndView;
    }
}

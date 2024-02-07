package com.example.module11.controller;

import com.example.module11.entity.User;
import com.example.module11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("showAllUsers");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAddUsersForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @GetMapping("/edit/{userId}")
    public ModelAndView getEditUsersForm(@PathVariable("userId") String userId) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.getUserById(Long.valueOf(userId));
        if (user.isPresent()) {
            modelAndView.addObject("id", userId);
            modelAndView.addObject("name", user.get().getName());
            modelAndView.addObject("age", user.get().getAge());
        } else {
            modelAndView.addObject("id", "unknown user");
            modelAndView.addObject("name", "unknown user");
            modelAndView.addObject("age", "unknown user");
        }
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteById(Long.valueOf(userId));
        return "redirect:../users";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam HashMap<String, String> req) {
        long id = Long.parseLong(req.get("id"));
        String name = req.get("name");
        int age = Integer.parseInt(req.get("age"));
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userService.updateById(user);
        return "redirect:users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam HashMap<String, String> req) {
        String name = req.get("name");
        int age = Integer.parseInt(req.get("age"));
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.createUser(user);
        return "redirect:users";
    }
}

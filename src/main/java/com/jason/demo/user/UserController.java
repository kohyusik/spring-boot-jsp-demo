package com.jason.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-16
 * @description :
 */
@Controller
@RequestMapping(path = "/api")
public class UserController {
    
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = { "/users" })
    @ResponseBody
    public List<User> members() {

        return userService.findAll();

    }


    @GetMapping(path = { "/user/{id}" })
    @ResponseBody
    public User member(@PathVariable Long id) {

        return userService.findById(id);

    }

    @GetMapping(path = { "/user/custom" })
    @ResponseBody
    public List<User> memberCustom() {

        return userService.findCustom();

    }
}
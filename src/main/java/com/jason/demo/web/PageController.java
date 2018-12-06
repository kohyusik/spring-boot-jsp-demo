package com.jason.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    
    @GetMapping({ "/owner" })
    public String login(HttpServletRequest req) {
        return "owner/list";
    }
}

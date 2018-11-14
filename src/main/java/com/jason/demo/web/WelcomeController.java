package com.jason.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {
    
    @Value("${application.message:Hello World}")
    private String message = "Hello World";
    
    @GetMapping({ "/" })
    public String index() {
        return "index";
    }
    
    
    @GetMapping({ "/login" })
    public String login(HttpServletRequest req) {

        System.out.println(">>>>>>>>>> : /login");
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage", referer);
        return "login";
    }
    
    @GetMapping("/all")
    public String welcome(Map<String, Object> model) {
        
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }
    
    @RequestMapping("/fail")
    public String fail() {
        
        throw new MyException("Oh dear!");
    }
    
    @RequestMapping("/fail2")
    public String fail2() {
        
        throw new IllegalStateException();
    }
    
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    MyRestResponse handleMyRuntimeException(MyException exception) {
        
        return new MyRestResponse("Some data I want to send back to the client.");
    }
    
    @GetMapping("/admin")
    public String admin() {
        
        return "admin";
    }
    
    @GetMapping("/user")
    public String user() {
        
        return "user";
    }
    
    @GetMapping("/ping")
    public @ResponseBody
    String ping() {
        
        return new Date().toString();
    }
}

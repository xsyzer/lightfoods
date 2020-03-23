package com.antake.ssm.controller;
import com.antake.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Integer> login(@RequestBody Map<String,String> params, HttpSession session){
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        if (username==null || password==null || username.length() <5 || password.length() <5){
            return ResponseEntity.ok(-102);
        }
        int result=userService.login(username,password);
        if (result==101){
            session.setAttribute("user",username);
        }
        return ResponseEntity.ok(result);
    }
}


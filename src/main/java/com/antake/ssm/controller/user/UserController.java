package com.antake.ssm.controller.user;
import com.alibaba.fastjson.JSONObject;
import com.antake.ssm.service.UserService;
import com.antake.ssm.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //登录页面
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    //登录逻辑
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<JSONObject> login(@RequestBody Map<String,String> params, HttpSession session){
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        if (username==null || password==null || username.length() <5 || password.length() <5){
            return ResponseEntity.ok(ResponseJson.respJson(-102,""));
        }
        int result=userService.login(username,password);
        if (result==101){
            session.setAttribute("user",username);
            return ResponseEntity.ok(ResponseJson.respJson(101,"/"));
        }
        return ResponseEntity.ok(ResponseJson.respJson(result,""));
    }
    //注册页面
    @GetMapping("/register")
    public String register(){
        return "/user/register";
    }
    //注册逻辑
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<JSONObject> register(@RequestBody Map<String,String> params){
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        if ("".equals(username) || "".equals(password) || username.length()<5 || password.length()<5){
            return ResponseEntity.ok(ResponseJson.respJson(-101,"用户注册请求参数异常"));
        }
        return userService.register(params);
    }
}


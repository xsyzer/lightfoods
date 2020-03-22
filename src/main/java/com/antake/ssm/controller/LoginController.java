package com.antake.ssm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Integer> login(@RequestBody Map<String,Object> params){
        System.out.println(params);
        return ResponseEntity.ok(1);
    }
}


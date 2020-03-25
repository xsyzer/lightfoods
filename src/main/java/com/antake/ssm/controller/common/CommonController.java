package com.antake.ssm.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
    @GetMapping("/header")
    public String header(){
        return "common/header";
    }
    @GetMapping("/footer")
    public String footer(){
        return "common/footer";
    }
}


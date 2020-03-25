package com.antake.ssm.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    int login(String username, String password);

    ResponseEntity<JSONObject> register(Map<String, String> params);
}

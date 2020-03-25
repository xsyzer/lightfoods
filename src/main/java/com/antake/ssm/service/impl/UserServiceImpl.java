package com.antake.ssm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.antake.ssm.dao.UserDao;
import com.antake.ssm.pojo.User;
import com.antake.ssm.service.AdminService;
import com.antake.ssm.service.UserService;
import com.antake.ssm.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AdminService adminService;

    @Override
    @Transactional
    public int login(String username, String password) {
        User user = userDao.getUser(username);
        int result=-101;
        if (user==null){
            return result;
        }
        //小黑屋到期
        if (user.getStatus()==2){
            boolean isBaned=adminService.checkBlackHouse(user);
            if (isBaned){
                return -103;
            }
        }
        if (user.getStatus()==1){
            if (password.equals(user.getPassword())){
                //修改上一次登录时间
                userDao.setLastLoginTime(username);
                return 101;
            }
            return -102;
        }else {
            switch (user.getStatus()) {
                case 0:
                    result = -101;
                    break;
                case 2:
                    result = -103;
                    break;
                case 3:
                    result = -104;
                    break;
                default:
                    break;
            }
            return result;
        }
    }

    @Override
    @Transactional
    public ResponseEntity<JSONObject> register(Map<String, String> params) {
        //检查用户名存不存在
        User user = userDao.getUser(params.get("username").toString().trim());
        if (user!=null){
            return ResponseEntity.ok(ResponseJson.respJson(-102,"用户名已存在"));
        }
        int result=userDao.register(params);
        if (result>0){
            return ResponseEntity.ok(ResponseJson.respJson(101,"注册成功"));
        }else {
            return ResponseEntity.ok(ResponseJson.respJson(103,"注册失败"));
        }
    }
}


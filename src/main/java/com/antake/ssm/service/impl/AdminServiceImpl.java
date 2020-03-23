package com.antake.ssm.service.impl;

import com.antake.ssm.dao.AdminDao;
import com.antake.ssm.pojo.User;
import com.antake.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    @Transactional
    public boolean checkBlackHouse(User user) {
        int count=adminDao.getBanedCountByUsername(user.getUsername());
        if (count>0){
            return true;
        }else {
            adminDao.setUserStatus(user.getUsername(),1);
            user.setStatus(1);
            return false;
        }
    }
}


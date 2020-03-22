package com.antake.ssm.service.impl;

import com.antake.ssm.dao.UserDao;
import com.antake.ssm.pojo.User;
import com.antake.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Transactional(readOnly = true)
    public int login(String username, String password) {
        User user = userDao.getUser(username);
        int result=-101;
        if (user==null){
            return result;
        }
        if (user.getStatus()==1){
            if (password.equals(user.getPassword())){
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
}


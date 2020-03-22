package com.antake.ssm.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private long uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Date reg_time;
    private Date last_login_time;
    private int status;
}


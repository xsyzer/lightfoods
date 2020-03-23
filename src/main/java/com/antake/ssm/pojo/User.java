package com.antake.ssm.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;

@Data
public class User implements UserDetails {
    private long uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Date reg_time;
    private Date last_login_time;
    private int status;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    //用户拥有的所有权限
    private List<GrantedAuthority> authorities;

    @Override
    public boolean isEnabled() {
        if (this.status==1){
            return true;
        }else {
            return false;
        }
    }
}


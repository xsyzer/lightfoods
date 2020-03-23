package com.antake.ssm.dao;

import com.antake.ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    @Select("SELECT uid,username,`password`,salt,phone,email,reg_time,last_login_time,`status` FROM `user` where username=#{username}")
    User getUser(@Param("username")String username);
    @Update("update user set last_login_time=now() where username=#{username}")
    void setLastLoginTime(@Param("username") String username);
}


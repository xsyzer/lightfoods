package com.antake.ssm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminDao {
    @Select("select count(*) from blackhouse WHERE user_username=#{username} AND due_time>now()")
    int getBanedCountByUsername(@Param("username") String username);
    @Update("update user set status=#{status} where username=#{username}")
    void setUserStatus(@Param("username") String username,@Param("status") int status);
}

package com.antake.ssm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminDao {
    /**
    * @Description: 查询用户当前是否在关禁闭
    * @Param: [username]
    * @return: int
    * @Author: MiZiMi
    * @Date: 2020/3/23 21:27
    */
    @Select("select count(*) from blackhouse WHERE user_username=#{username} AND due_time>now()")
    int getBanedCountByUsername(@Param("username") String username);
    /**
    * @Description: 根据用户名修改用户的状态
    * @Param: [username, status]
    * @return: void
    * @Author: MiZiMi
    * @Date: 2020/3/23 21:28
    */
    @Update("update user set status=#{status} where username=#{username}")
    void setUserStatus(@Param("username") String username,@Param("status") int status);
}

package com.antake.ssm.dao;

import com.antake.ssm.pojo.Permission;
import com.antake.ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    /**
    * @Description: 查询当前用户信息
    * @Param: [username]
    * @return: com.antake.ssm.pojo.User
    * @Author: MiZiMi
    * @Date: 2020/3/23 21:25
    */
    @Select("SELECT uid,username,`password`,salt,phone,email,reg_time,last_login_time,`status`,accountNonExpired,accountNonLocked,credentialsNonExpired FROM `user` where username=#{username}")
    User getUser(@Param("username")String username);
    /**
    * @Description: 更新用户上一次登录时间
    * @Param: [username]
    * @return: void
    * @Author: MiZiMi
    * @Date: 2020/3/23 21:25
    */
    @Update("update user set last_login_time=now() where username=#{username}")
    void setLastLoginTime(@Param("username") String username);
    /**
    * @Description: 根据用户名查找用户权限
    * @Param: [username]
    * @return: java.util.List<com.antake.ssm.pojo.Permission>
    * @Author: MiZiMi
    * @Date: 2020/3/23 21:27
    */
    @Select("SELECT permission.id,permission.`name`,permission.tag from `user` INNER JOIN user_role on `user`.uid=user_role.user_id INNER JOIN role_permission ON user_role.role_id=role_permission.role_id INNER JOIN permission on role_permission.perm_id=permission.id WHERE `user`.username=#{username}")
    List<Permission> findPermissionByUsername(@Param("username") String username);
}


package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    //多个参数前需要加上@Param()注解
    @Select("select * from user where id = #{idNew}")
    User getUserById(@Param("idNew") int id);

    @Insert("insert into user values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name = #{name},pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int delete(@Param("uid") int id);

}

package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User queryById(@Param("id") int id);

    int updateUser(User user);
}

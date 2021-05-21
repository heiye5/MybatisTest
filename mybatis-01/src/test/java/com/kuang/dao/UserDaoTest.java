package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void Test(){
        //1.获取SqlSession对象
        SqlSession sqlSession = null;


        try{
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            //方式二
//        List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("j");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 按id查询用户
     */
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    /**
     * 按id查询用户map
     */
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",5);
        map.put("name","4g");
        mapper.addUser2(map);

        sqlSession.close();
    }

    /**
     * 添加用户
     */
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int re = mapper.addUser(new User(5,"zhngsdn","347854"));
        if(re > 0){
            System.out.println("成功");
        }

        //提交事务
//        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * map插入
     */
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("Id",5);
        map.put("userName","4g");
        map.put("password","12345");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"jd","12345"));

//        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.daleteUser(1);

        sqlSession.commit();
        sqlSession.close();
    }
}

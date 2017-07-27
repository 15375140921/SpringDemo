package com.gta.dao;

import com.gta.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserDao
 * Created by ningning.jiang on 2017/6/26.
 */
public interface UserDao {

    /**
     * 获取所有用户数量
     *
     * @return int 用户总数
     */
    int countUser();

    /**
     * 获取单个用户
     *
     * @return User 用户
     */
    User getUserById(@Param("id") int id);

    /**
     * 获取所有的User
     *
     * @return UserList 所有User
     */
    List<User> listUser();

    /**
     * 根据姓名获取单个用户
     *
     * @return User 用户
     */
    User getUserByName(@Param("username")String username);
}

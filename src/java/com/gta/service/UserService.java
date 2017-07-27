package com.gta.service;

import com.gta.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 * Created by ningning.jiang on 2017/6/26.
 */
public interface UserService {

    /**
     * 获取用户总数
     *
     * @return int 用户总数
     */
    int countUser();

    /**
     * 获取单个用户
     *
     * @return User 用户
     */
    User getUserById(int id);

    /**
     * 获取所有的User
     *
     * @return UserList 所有User
     */
    List<User> listUser();

    /**
     * 根据姓名获取单个User
     *
     * @return UserList 所有User
     */
    User getUserByName(String username);
}

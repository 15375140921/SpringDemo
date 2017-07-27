package com.gta.service.impl;

import com.gta.dao.UserDao;
import com.gta.model.User;
import com.gta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * Created by ningning.jiang on 2017/6/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int countUser() {
        return userDao.countUser();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}

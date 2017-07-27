package com.gta.model;

import java.io.Serializable;

/**
 * User实体类
 * Created by ningning.jiang on 2017/6/26.
 */
public class User implements Serializable{

    private String userName;//姓名
    private String passWord;//年龄

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return userName;
    }
}

package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.dao.UserDao;
import com.wanke.nanjidao.entity.User;
import com.wanke.nanjidao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:09 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:用户服务实例
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String name, String pwd) {
        return userDao.getUser(name, pwd);
    }
}

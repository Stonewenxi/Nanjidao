package com.wanke.nanjidao.dao;

import com.wanke.nanjidao.entity.User;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:01 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:用户相关接口
 */
public interface UserDao {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:01 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 根据账户,密码返回用户
     *
     * @param name 账户名
     * @param pwd  密码
     * @return 用户
     */
    User getUser(String name, String pwd);

}

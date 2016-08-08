package com.wanke.nanjidao.service;

import com.wanke.nanjidao.entity.User;
import org.springframework.stereotype.Service;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:07 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:用户服务
 */
@Service
public interface UserService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:07 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 检查用户是否为管理员
     */
    User checkUser(String name, String pwd);

}

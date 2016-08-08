package com.wanke.nanjidao.config;

import com.wanke.nanjidao.entity.User;

import javax.servlet.http.HttpSession;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:41 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:Session管理器
 */
public class SessionManage {

    // 管理员Session存储
    private static final String MANAGER_SESSION_USER = "MANAGER_SESSION_USER";

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:45 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取Session里的用户信息
     */
    public static User getUser(HttpSession session) {
        if (session == null) {
            return null;
        }
        return (User) session.getAttribute(MANAGER_SESSION_USER);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:48 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 存储Session信息
     */
    public static void saveUser(HttpSession session, User user) {
        if (session != null && user != null) {
            session.setAttribute(MANAGER_SESSION_USER, user);
        }
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 12:52 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 移除Session信息
     */
    public static void removeUser(HttpSession session) {
        session.removeAttribute(MANAGER_SESSION_USER);
    }
}

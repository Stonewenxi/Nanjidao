package com.wanke.nanjidao.controller.manage;

import com.wanke.nanjidao.bean.StatusBean;
import com.wanke.nanjidao.config.SessionManage;
import com.wanke.nanjidao.entity.User;
import com.wanke.nanjidao.service.UserService;
import com.wanke.nanjidao.util.LogUtil;
import com.wanke.nanjidao.util.SecurityUtil;
import com.wanke.nanjidao.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:11 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:管理员相关操作
 */
@Controller
@RequestMapping("/manage")
public class ManageUserController {

    @Autowired
    private UserService userService;

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 12:50 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 登陆
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean login(HttpSession session, String admin, String password) {
        LogUtil.info("ManageUserController:" + "请求登陆");
        StatusBean statusBean = new StatusBean();
        if (StringUtil.isEmpty(admin) || StringUtil.isEmpty(password)) {
            statusBean.setFlag(false);
            return statusBean;
        }

        try {
            String temp = new String(new BASE64Decoder().decodeBuffer(password), "UTF-8");
            String pwd = SecurityUtil.parseStrToMd5L32(temp.substring(6) + "56");

            User user = userService.checkUser(admin, pwd);
            if (user == null) {
                LogUtil.info("ManageUserController:" + "用户登陆失败");
                statusBean.setFlag(false);
                return statusBean;
            }

            LogUtil.info("ManageUserController:" + "用户登陆成功");
            SessionManage.saveUser(session, user);
            session.setAttribute("user", user.getAdmin());
            statusBean.setFlag(true);
        } catch (IOException e) {
            e.printStackTrace();
            statusBean.setFlag(false);
        }
        return statusBean;
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 12:53 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 登出
     */
    @RequestMapping("/logout.do")
    @ResponseBody
    public StatusBean logOut(HttpSession session) {
        SessionManage.removeUser(session);
        StatusBean statusBean = new StatusBean();
        statusBean.setFlag(true);
        return statusBean;
    }

}

package com.wanke.nanjidao.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 1:54 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:后台的页面控制器
 */
@Controller
@RequestMapping("/manage")
public class ManagePageController {

    @RequestMapping("/login")
    public String login() {
        return "manage/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "manage/index";
    }

}

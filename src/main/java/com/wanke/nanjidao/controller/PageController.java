package com.wanke.nanjidao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 12:31 PM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 项目页面控制器,根据请求返回相关页面
 */
@Controller
@RequestMapping("/")
public class PageController {

    /**
     * *******************************************
     * Author 56
     * Data   3/11/16 3:30 PM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @function 返回主页
     */
    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "0") int id, Model model) {
        model.addAttribute("sortId", id);
        return "index";
    }

    /**
     * *******************************************
     * Author 56
     * Data   3/11/16 11:35 AM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @param id    传来的id参数
     * @param model model即视图类,用于生成页面
     * @function 根据项目id组装网页返回相关项目详情页
     */
    @RequestMapping("/details")
    public String details(int id, Model model) {
        model.addAttribute("projectId", id);
        return "details";
    }

    @RequestMapping("/manage")
    public String redirect() {
        return "redirect:/manage/login";
    }
}

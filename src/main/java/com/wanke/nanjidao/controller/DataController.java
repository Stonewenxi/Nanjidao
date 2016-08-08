package com.wanke.nanjidao.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanke.nanjidao.bean.ProjectBasic;
import com.wanke.nanjidao.bean.ProjectList;
import com.wanke.nanjidao.bean.StatusBean;
import com.wanke.nanjidao.entity.Financiers;
import com.wanke.nanjidao.entity.Project;
import com.wanke.nanjidao.entity.Sorts;
import com.wanke.nanjidao.service.InvestorService;
import com.wanke.nanjidao.service.ProjectService;
import com.wanke.nanjidao.service.SortService;
import com.wanke.nanjidao.service.WeChatService;
import com.wanke.nanjidao.util.LogUtil;
import com.wanke.nanjidao.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * *******************************************
 * Author 56
 * Data   3/11/16 2:22 PM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 数据控制器,根据相应请求返回相关数据
 */
@Controller
@RequestMapping("/project")
public class DataController {

    @Autowired
    private SortService sortService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private WeChatService weChatService;

    /**
     * *******************************************
     * Author 56
     * Data   3/11/16 11:47 AM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @param id 查找用的id
     * @function 根据id返回相关的数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public Project find(int id) {
        LogUtil.info("DataController:" + "请求项目 id:" + id);

        try {
            return projectService.selectById(id);
        } catch (Exception e) {
            LogUtil.info("DataController:" + "请求项目错误:" + e.toString());
            return new Project();
        }
    }

    /**
     * *******************************************
     * Author 56
     * Data   3/11/16 9:27 AM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @function 返回数据库查找到的项目列表
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public ProjectList findAll(String sortId) {
        LogUtil.info("DataController:" + "请求获取全部项目基本信息");
        int sortId_i = 0;
        if(!StringUtil.isEmpty(sortId)) {
            sortId_i = Integer.valueOf(sortId);
        }
        ProjectList projectList;
        Sorts sorts;
        try {
            if (sortId_i != 0) {
                sorts = sortService.findSortById(sortId_i);
            } else {
                sorts = new Sorts();
                sorts.setId(0);
            }

            List<ProjectBasic> projectBasics = projectService.selectProjectBasic(sortId_i);
            projectList = new ProjectList();
            projectList.setSort(sorts);
            projectList.setList(projectBasics);
            return projectList;
        } catch (IllegalStateException ex) {
            System.out.println(ex.toString());
            return new ProjectList();
        }
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/15/16 11:46 AM
     * EMail:  mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 提交投资人信息
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean submit(String json) {
        Financiers financiers = new Financiers();
        StatusBean statusBean = new StatusBean();
        try {
            JsonNode node = new ObjectMapper().readValue(json, JsonNode.class);

            financiers.setName(node.findValue("name").toString());
            financiers.setGender(node.findValue("gender").asInt());
            financiers.setPhone(node.findValue("phone").toString());
            financiers.setUnit(node.findValue("unit").toString());
            financiers.setEmail(node.findValue("email").toString());
            financiers.setProjectId(node.findValue("projectId").asInt());

            investorService.insert(financiers);
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
     * Data:   3/22/16 4:59 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 分享接口,返回数字签名,随机数等
     */
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean share(String url) {
        StatusBean statusBean = new StatusBean();
        HashMap<String, String> params = weChatService.getParams(url);
        statusBean.setFlag(params);

        return statusBean;
    }
}

package com.wanke.nanjidao.controller.manage;

import com.wanke.nanjidao.bean.Investor;
import com.wanke.nanjidao.bean.ProjectWithSort;
import com.wanke.nanjidao.bean.StatusBean;
import com.wanke.nanjidao.entity.Project;
import com.wanke.nanjidao.service.CommonDataService;
import com.wanke.nanjidao.service.InvestorService;
import com.wanke.nanjidao.service.ProjectService;
import com.wanke.nanjidao.service.SortService;
import com.wanke.nanjidao.util.LogUtil;
import com.wanke.nanjidao.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 1:55 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:后台数据相关操作
 */
@Controller
@RequestMapping("/manage")
public class ManageDataController {

    @Autowired
    private SortService sortService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private CommonDataService commonDataService;

    /* 分界线 ***** 说明:  项目相关数据操作以下*/

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
     * Author: 56
     * Data:   3/16/16 11:31 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取所有项目的全部信息
     *
     * @return 返回所有项目的全部信息列表
     */
    @RequestMapping("/projects")
    @ResponseBody
    public List<ProjectWithSort> findProject() {
        LogUtil.info("DataController:" + "请求获取全部项目");
        try {
            return projectService.selectAllWithSort();
        } catch (Exception e) {
            LogUtil.info("请求获取全部项目错误:" + e.toString());
            return new ArrayList<>();
        }
    }

    @RequestMapping("/findSort")
    @ResponseBody
    public List findSorts() {
        try {
            return sortService.selectAll();
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 3:58 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 接受项目信息,插入新项目
     */
    @RequestMapping(value = "/projects/add", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean addProject(HttpServletRequest request, String title,
                                 String subTitle, String sorts, String remark, MultipartFile logo,
                                 String htmlCode) {
        String path = request.getSession().getServletContext().getRealPath("/");
        StatusBean statusBean = new StatusBean();

        if (title == null || title.equals("")
                || subTitle == null || subTitle.equals("")) {
            statusBean.setFlag(false);
            return statusBean;
        }

        // 文件存储
        String logoName = "";
        if (logo != null && !logo.isEmpty()) {
            logoName = "logo" + new Date().getTime() + ".png";
            commonDataService.saveFile(path, logo, "logo", logoName);
        }
        Project project = new Project();
        project.setTitle(title);
        project.setSorts(Integer.parseInt(sorts));
        project.setSubTitle(subTitle);
        project.setRemark(remark);
        project.setLogo(logoName);
        project.setHtmlCode(htmlCode);

        statusBean.setFlag(projectService.insert(project));
        return statusBean;
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 8:41 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取前端传来的项目更新数据
     */
    @RequestMapping(value = "/projects/update", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean updateProject(HttpServletRequest request, int id, String title,
                                    String subTitle, String sorts, String remark, MultipartFile logo,
                                    String htmlCode) {
        String path = request.getSession().getServletContext().getRealPath("/");
        // 文件存储
        String logoName = "";
        if (logo != null && !logo.isEmpty()) {
            logoName = "logo" + new Date().getTime() + ".png";
            commonDataService.saveFile(path, logo, "logo", logoName);
        }

        HashMap<String, String> maps = new HashMap<>();
        if (!StringUtil.isEmpty(title)) {
            maps.put("title", title);
        }
        if (!StringUtil.isEmpty(subTitle)) {
            maps.put("subTitle", subTitle);
        }
        if (!StringUtil.isEmpty(remark)) {
            maps.put("remark", remark);
        }
        if (!StringUtil.isEmpty(logoName)) {
            maps.put("logo", logoName);
        }
        if (!StringUtil.isEmpty(htmlCode)) {
            maps.put("htmlCode", htmlCode);
        }
        if (!StringUtil.isEmpty(sorts)) {
            maps.put("sorts", sorts);
        }

        StatusBean statusBean = new StatusBean();
        statusBean.setFlag(false);
        if (maps.size() != 0) {
            projectService.update(maps, id);
            statusBean.setFlag(true);
        }
        return statusBean;
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 1:49 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 根据id移除相关项目
     */
    @RequestMapping(value = "/projects/remove", method = RequestMethod.POST)
    @ResponseBody
    public StatusBean removeProject(int[] ids) {
        if (ids != null && ids.length != 0) {
            for (int id : ids) {
                projectService.removeProject(id);
            }
        }
        return new StatusBean();
    }

     /* 分界线 ***** 说明:  项目相关数据操作以上*/

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 2:01 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function:返回所有投资人投资信息
     */
    @RequestMapping("/investors")
    @ResponseBody
    public List<Investor> findInvestors() {
        LogUtil.info("请求获取投资人信息");

        try {
            return investorService.selectAll();
        } catch (Exception e) {
            LogUtil.info("请求获取投资人信息错误:" + e.toString());
            return new ArrayList<>();
        }
    }

}

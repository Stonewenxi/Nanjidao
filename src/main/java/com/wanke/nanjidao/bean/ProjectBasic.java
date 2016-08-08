package com.wanke.nanjidao.bean;

import com.wanke.nanjidao.entity.Project;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 11:33 AM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 项目简单信息
 */
public class ProjectBasic {

    private int id;                 // 项目id
    private String title = "";      // 主标题
    private String subTitle = "";   // 副标题
    private int interest = 0;       // 感兴趣的人
    private String remark = "暂无"; // 简介
    private String logo = "";       // Logo 图片名

    private ProjectBasic(int id, String title, String subTitle, int interest, String remark, String logo) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.interest = interest;
        this.remark = remark;
        this.logo = logo;
    }

    /**
     * *******************************************
     * Author 56
     * Data   3/9/16 11:42 AM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @param project 要获取基本的项目类
     * @return 获取到的基本信息类
     * @function 返回项目的基本信息类
     */
    public static ProjectBasic getBasic(Project project) {
        return new ProjectBasic(
                project.getId(),
                project.getTitle(),
                project.getSubTitle(),
                project.getInterest(),
                project.getRemark(),
                project.getLogo()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

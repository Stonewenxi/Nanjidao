package com.wanke.nanjidao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 11:17 AM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 项目的基本信息
 */
@Entity
@Table
public class Project {

    @Id
    @GeneratedValue
    private int id;

    private String title = "";      // 主标题
    private String subTitle = "";   // 副标题
    private int interest = 0;       // 感兴趣的人
    private int state = 0;          // 项目状态 0 表示存在 1表示已删除
    private String remark = "暂无"; // 简介
    private String logo = "";       // Logo 图片名
    private String htmlCode = "";   // html代码文件名
    private int sorts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSorts() {
        return sorts;
    }

    public void setSorts(int sorts) {
        this.sorts = sorts;
    }
}

package com.wanke.nanjidao.bean;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 2:54 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:投资人信息展示类
 */
public class Investor {

    private int id;

    private String name;    // 投资人姓名
    private String phone;   // 投资人电话
    private String unit;    // 投资人单位
    private String email;   // 投资人邮箱
    private String project; // 投资人感兴趣的项目名称
    private String gender;  // 投资人性别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

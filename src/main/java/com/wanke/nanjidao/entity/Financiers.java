package com.wanke.nanjidao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * *******************************************
 * Author: 56
 * Data:   3/15/16 10:27 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function: 记录投资人的基本信息
 */
@Entity
@Table
public class Financiers {

    @Id
    @GeneratedValue
    private int id;

    private String name;    // 投资人姓名
    private String phone;   // 投资人电话
    private String unit;    // 投资人单位
    private String email;   // 投资人邮箱
    private int projectId;  // 投资人感兴趣的项目
    private int gender;     // 投资人性别

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}

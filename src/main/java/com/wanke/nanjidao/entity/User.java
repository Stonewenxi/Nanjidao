package com.wanke.nanjidao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 9:56 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:管理员信息表
 */
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String admin;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

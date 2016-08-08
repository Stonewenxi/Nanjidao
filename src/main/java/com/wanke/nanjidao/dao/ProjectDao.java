package com.wanke.nanjidao.dao;

import java.util.HashMap;

/**
 * *******************************************
 * Author: 56
 * Data:   3/17/16 4:13 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:项目出去共有操作外的其他操作
 */
public interface ProjectDao {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 4:06 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 刷新数据表中的一个对象
     */
    void update(HashMap<String, String> map, int id);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 9:15 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 数据表中感兴趣的人计数+1
     *
     * @param id 项目的id
     */
    void addOne(int id);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:14 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 移除项目,即更正项目状态
     */
    void remove(int id);
}

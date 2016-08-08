package com.wanke.nanjidao.dao;

import java.util.List;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 2:24 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:数据库操作相关接口
 */
public interface CommonDao {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 2:27 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 向数据表中添加一个对象
     */
    <T> int insert(T t);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 2:27 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 根据id和类类型查找对象
     */
    <T> Object selectById(Class<T> cls, int id);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 2:28 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 根据类类型返回所有相关信息
     */
    <T> List selectAll(Class<T> cls);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 1:55 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 依靠id进行删除
     */
//    <T> void remove(T t);
}

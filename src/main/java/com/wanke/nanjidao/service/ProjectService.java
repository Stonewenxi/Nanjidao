package com.wanke.nanjidao.service;

import com.wanke.nanjidao.bean.ProjectBasic;
import com.wanke.nanjidao.bean.ProjectWithSort;
import com.wanke.nanjidao.entity.Project;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 11:39 AM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 数据服务接口
 */
@Service
public interface ProjectService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 3:05 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 新增一个项目
     *
     * @param project 新增的项目
     * @return true 新增成功 false 新增失败
     */
    boolean insert(Project project);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 4:19 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 刷新数据表中的一个对象
     *
     * @param id  该对象的id
     * @param map 刷新的参数与更新值
     */
    void update(HashMap<String, String> map, int id);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 3:06 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 根据id从数据库获取到相关的项目信息
     *
     * @param id 查找用的id
     * @return 查找到的项目
     */
    Project selectById(int id);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 3:07 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 查找所有的项目完全的信息
     *
     * @return 所有的项目
     */
    List<Project> selectAll();

    List<ProjectWithSort> selectAllWithSort();

    /**
     * *******************************************
     * Author 56
     * Data   3/11/16 2:04 PM
     * EMail mysherrymyqueen@outlook.com
     * *******************************************
     *
     * @function 根据得到Project信息得到各个项目的简单信息
     */
    List<ProjectBasic> selectProjectBasic(int i);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 1:59 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 依靠id删除相应的项目
     *
     * @param id 项目id
     */
    void removeProject(int id);
}

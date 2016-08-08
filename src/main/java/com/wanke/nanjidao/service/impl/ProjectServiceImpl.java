package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.bean.ProjectBasic;
import com.wanke.nanjidao.bean.ProjectWithSort;
import com.wanke.nanjidao.dao.CommonDao;
import com.wanke.nanjidao.dao.ProjectDao;
import com.wanke.nanjidao.entity.Project;
import com.wanke.nanjidao.entity.Sorts;
import com.wanke.nanjidao.service.ProjectService;
import com.wanke.nanjidao.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 12:28 PM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 项目数据服务实现类
 */
@Service("DataService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    CommonDao commonDao;

    @Autowired
    ProjectDao projectDao;

    @Override
    public boolean insert(Project project) {
        int res = commonDao.insert(project);
        return res > 0;
    }

    @Override
    public void update(HashMap<String, String> map, int id) {
        projectDao.update(map, id);
    }

    @Override
    public Project selectById(int id) {
        Project project = (Project) commonDao.selectById(Project.class, id);
        LogUtil.info("查询单个项目" + project.toString());
        return project.getState() == 0 ? project : null;
    }

    @Override
    public List<Project> selectAll() {
        List<Project> tempList = null;
        try {
            tempList = commonDao.selectAll(Project.class);
        } catch (Exception e) {
            LogUtil.info("返回全部项目出错:" + e.toString());
        }

        if (tempList != null) {
            LogUtil.info("查询全部项目" + tempList.toString());
        }
        return tempList != null ? tempList.stream()
                .filter(project -> project.getState() == 0)
                .collect(Collectors.toList()) : null;
    }

    @Override
    public List<ProjectWithSort> selectAllWithSort() {
        List<Project> list = selectAll();
        List<ProjectWithSort> res = new ArrayList<>();
        for (Project project : list) {
            Sorts sorts = (Sorts) commonDao.selectById(Sorts.class, project.getSorts());
            ProjectWithSort projectWithSort = new ProjectWithSort();
            projectWithSort.setId(project.getId());
            projectWithSort.setTitle(project.getTitle());
            projectWithSort.setSubTitle(project.getSubTitle());
            projectWithSort.setSort(sorts.getName());
            projectWithSort.setLogo(project.getLogo());
            projectWithSort.setInterest(project.getInterest());
            projectWithSort.setRemark(project.getRemark());
            res.add(projectWithSort);
        }
        return res;
    }

    @Override
    public List<ProjectBasic> selectProjectBasic(int i) {
        List<Project> list = selectAll();
        LogUtil.info("查询全部项目基本信息" + list.toString());
        if (i == 0)
            return list.stream()
                    .filter(project -> project.getState() == 0)
                    .map(ProjectBasic::getBasic)
                    .collect(Collectors.toList());
        else
            return list.stream()
                    .filter(project -> project.getState() == 0)
                    .filter(project -> project.getSorts() == i)
                    .map(ProjectBasic::getBasic)
                    .collect(Collectors.toList());
    }

    @Override
    public void removeProject(int id) {
        projectDao.remove(id);
    }
}

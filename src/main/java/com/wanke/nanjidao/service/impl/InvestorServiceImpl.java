package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.bean.Investor;
import com.wanke.nanjidao.dao.CommonDao;
import com.wanke.nanjidao.dao.ProjectDao;
import com.wanke.nanjidao.entity.Financiers;
import com.wanke.nanjidao.entity.Project;
import com.wanke.nanjidao.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 3:03 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:投资人相关数据服务实现类
 */
@Service("InvestorService")
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    CommonDao commonDao;

    @Autowired
    ProjectDao projectDao;

    @Override
    public boolean insert(Financiers financiers) {
        int res = commonDao.insert(financiers);
        if (res > 0) {
            projectDao.addOne(financiers.getProjectId());
            return true;
        }
        return false;
    }

    @Override
    public List<Investor> selectAll() {
        List<Financiers> list = commonDao.selectAll(Financiers.class);
        List<Investor> resList = new ArrayList<>();
        for (Financiers financiers : list) {
            int id = financiers.getId();
            String name = financiers.getName();
            String email = financiers.getEmail();
            String phone = financiers.getPhone();
            String unit = financiers.getUnit();

            int genderInt = financiers.getGender();
            String gender = genderInt == 0 ? "女" : "男";

            int projectId = financiers.getProjectId();
            Project project = (Project) commonDao.selectById(Project.class, projectId);
            String projectName;

            if (project == null || project.getState() == 1) {
                projectName = "项目已经移除";
            } else {
                projectName = project.getTitle();
            }

            Investor investor = new Investor();
            investor.setId(id);
            investor.setName(name);
            investor.setEmail(email);
            investor.setPhone(phone);
            investor.setUnit(unit);
            investor.setGender(gender);
            investor.setProject(projectName);

            resList.add(investor);
        }
        return resList;
    }
}

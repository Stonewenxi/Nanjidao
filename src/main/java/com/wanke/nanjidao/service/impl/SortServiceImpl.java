package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.dao.CommonDao;
import com.wanke.nanjidao.entity.Financiers;
import com.wanke.nanjidao.entity.Sorts;
import com.wanke.nanjidao.service.SortService;
import com.wanke.nanjidao.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SortService")
public class SortServiceImpl implements SortService {

    @Autowired
    CommonDao commonDao;

    @Override
    public boolean insert(Financiers financiers) {
        return false;
    }

    @Override
    public Sorts findSortById(int i) {
        Sorts sorts = (Sorts) commonDao.selectById(Sorts.class, i);
        if (sorts == null) {
            return null;
        } else {
            LogUtil.info((new StringBuilder()).append("get sorts").append(sorts.toString()).toString());
            return sorts;
        }
    }

    @Override
    public List selectAll() {
        return commonDao.selectAll(Sorts.class);
    }
}

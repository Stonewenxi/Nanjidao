package com.wanke.nanjidao.service;

import com.wanke.nanjidao.entity.Financiers;
import com.wanke.nanjidao.entity.Sorts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortService {

    boolean insert(Financiers financiers);

    Sorts findSortById(int i);

    List selectAll();

}

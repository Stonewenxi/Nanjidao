package com.wanke.nanjidao.service;

import com.wanke.nanjidao.bean.Investor;
import com.wanke.nanjidao.entity.Financiers;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************************
 * Author: 56
 * Data:   3/16/16 3:02 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:投资人相关的数据服务类
 */
@Service
public interface InvestorService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 3:11 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 新增一个投资人
     *
     * @param financiers 新增的投资人
     * @return true 新增成功 false 新增失败
     */
    boolean insert(Financiers financiers);

    /**
     * *******************************************
     * Author: 56
     * Data:   3/16/16 3:12 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 查找所有的投资人的信息
     *
     * @return 所有的投资人
     */
    List<Investor> selectAll();
}

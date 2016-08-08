package com.wanke.nanjidao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * *******************************************
 * Author: 56
 * Data:   3/17/16 11:41 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:通用数据服务类
 */
@Service
public interface CommonDataService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 11:43 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 存储单个文件
     *
     * @param basePath web根路径
     * @param file     存储的文件
     * @param sort     文件的分类
     * @param name     文件名
     * @return 文件名
     */
    String saveFile(String basePath, MultipartFile file, String sort, String name);

}

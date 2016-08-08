package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.service.CommonDataService;
import com.wanke.nanjidao.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * *******************************************
 * Author: 56
 * Data:   3/17/16 11:45 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:通用数据服务类实例
 */
@Service("CommonDataService")
public class CommonDataServiceImpl implements CommonDataService {

    @Override
    public String saveFile(String basePath, MultipartFile file, String sort, String name) {
        String res = "";
        if (file != null && !file.isEmpty()) {
            res = FileUtil.saveFile(file, basePath + "view/" + sort, name);
        }
        return res;
    }
}

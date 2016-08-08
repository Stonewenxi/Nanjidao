package com.wanke.nanjidao.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 2:20 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:微信相关服务
 */
@Service
public interface WeChatService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 3:05 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取参数如: 时间戳,随机字符串,签名
     *
     * @param url 当前网页
     */
    HashMap<String, String> getParams(String url);

}

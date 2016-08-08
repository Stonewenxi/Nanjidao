package com.wanke.nanjidao.service.impl;

import com.wanke.nanjidao.config.WeChatManage;
import com.wanke.nanjidao.service.WeChatService;
import com.wanke.nanjidao.util.LogUtil;
import com.wanke.nanjidao.util.StringUtil;
import com.wanke.nanjidao.util.TimeUtil;
import com.wanke.nanjidao.util.WeChatUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 2:25 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:微信相关服务
 */
@Service("WeChatService")
public class WeChatServiceImpl implements WeChatService {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 4:52 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 刷新微信配置
     */
    private void updateManage() {
        LogUtil.info("开始刷新微信配置");
        WeChatManage.setTokenJson(WeChatUtil.getToken());
        WeChatManage.setTimeStamp(TimeUtil.getTimeStamp());
        WeChatManage.setRandomString(StringUtil.random(16));
        WeChatManage.setJsApiTicket(WeChatUtil.getTicket());
        LogUtil.info("微信配置完成");
    }


    @Override
    public HashMap<String, String> getParams(String url) {
        long current = System.currentTimeMillis() / 1000;
        String oldStr = WeChatManage.getTimeStamp();
        long old = 0;
        if (!StringUtil.isEmpty(oldStr)) {
            old = Long.parseLong(oldStr);
        }
        if (current - old > 3600) {
            updateManage();
        }

        LogUtil.info("开始生成微信签名");

        String signature = WeChatUtil.signature(url);
        HashMap<String, String> maps = new HashMap<>();
        maps.put("signature", signature);
        maps.put("appId", WeChatManage.getAppId());
        maps.put("timestamp", WeChatManage.getTimeStamp());
        maps.put("nonceStr", WeChatManage.getRandomString());
        return maps;
    }
}

package com.wanke.nanjidao.util;

import com.wanke.nanjidao.config.WeChatManage;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 11:53 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:微信相关服务
 */
public class WeChatUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 11:59 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 微信签名生成
     *
     * @return 生成的签名
     */
    public static String signature(String url) {
        String builder = "jsapi_ticket=" +
                WeChatManage.getJsApiTicket() +
                "&noncestr=" +
                WeChatManage.getRandomString() +
                "&timestamp=" +
                WeChatManage.getTimeStamp() +
                "&url=" +
                url;

        return SecurityUtil.parseStrToSHA1(builder);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 1:29 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 请求获得Token
     */
    public static String getToken() {
        String httpsUrl = WeChatManage.getTokenUrl() + "grant_type=client_credential" +
                "&appid=" + WeChatManage.getAppId() +
                "&secret=" + WeChatManage.getAppSecret();

        return NetUtil.httpsGet(httpsUrl);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 4:33 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取临时票据
     */
    public static String getTicket() {
        String httpsUrl = WeChatManage.getTicketUrl() + "access_token="
                + WeChatManage.getTokenJson() + "&type=jsapi";

        return NetUtil.httpsGet(httpsUrl);
    }
}

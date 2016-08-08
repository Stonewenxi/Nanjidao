package com.wanke.nanjidao.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanke.nanjidao.util.LogUtil;

import java.io.IOException;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 11:45 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:微信相关的全局缓存
 */
public class WeChatManage {

    private static final String APP_ID = "wx8560dfca64579426";
    private static final String APP_SECRET = "ce2e7a4c21f75e9c68c7dc192b06614e";
    private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";
    private static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";

    private static String tokenJson;     // Token json内容
    private static String jsApiTicket;   // js api 临时票据
    private static String randomString;  // 随机字符串
    private static String timeStamp = "0";     // 时间戳

    public static String getTokenUrl() {
        return TOKEN_URL;
    }

    public static String getAppId() {
        return APP_ID;
    }

    public static String getAppSecret() {
        return APP_SECRET;
    }

    public static String getRandomString() {
        return randomString;
    }

    public static void setRandomString(String randomString) {
        WeChatManage.randomString = randomString;
    }

    public static String getJsApiTicket() {
        return jsApiTicket;
    }

    public static void setJsApiTicket(String jsonStr) {
        String jsApiTicket = "";
        try {
            JsonNode node = new ObjectMapper().readValue(jsonStr, JsonNode.class);
            jsApiTicket = node.findValue("ticket").toString();
            jsApiTicket = jsApiTicket.substring(1, jsApiTicket.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeChatManage.jsApiTicket = jsApiTicket;
        LogUtil.info("微信临时票据:" + jsApiTicket);
    }

    public static String getTimeStamp() {
        return timeStamp;
    }

    public static void setTimeStamp(String timeStamp) {
        WeChatManage.timeStamp = timeStamp;
    }

    public static String getTokenJson() {
        return tokenJson;
    }

    public static void setTokenJson(String tokenJson) {
        String token = "";
        try {
            JsonNode node = new ObjectMapper().readValue(tokenJson, JsonNode.class);
            token = node.findValue("access_token").toString();
            token = token.substring(1, token.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeChatManage.tokenJson = token;
        LogUtil.info("微信token:" + token);
    }

    public static String getTicketUrl() {
        return TICKET_URL;
    }
}

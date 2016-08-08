package com.wanke.nanjidao.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 4:38 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:网络请求相关方法
 */
public class NetUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 4:40 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: Https请求
     *
     * @param httpsUrl 请求的网页链接
     * @return 返回内容
     */
    public static String httpsGet(String httpsUrl) {
        BufferedReader reader = null;
        String res = null;

        try {
            URL url = new URL(httpsUrl);

            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder builder = new StringBuilder();
            String input;

            while ((input = reader.readLine()) != null) {
                builder.append(input);
            }

            res = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

}

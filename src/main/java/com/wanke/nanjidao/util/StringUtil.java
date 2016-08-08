package com.wanke.nanjidao.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 11:13 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:字符串工具类
 */
public class StringUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 11:14 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 3:17 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 生成随机字符串 字符串为 大小写字母加数字组成
     *
     * @param length 字符串长度
     */
    public static String random(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch (ThreadLocalRandom.current().nextInt(1, 4)) {
                case 1:
                    builder.append((char) (ThreadLocalRandom.current().nextInt(48, 58)));
                    break;
                case 2:
                    builder.append((char) (ThreadLocalRandom.current().nextInt(65, 91)));
                    break;
                case 3:
                    builder.append((char) (ThreadLocalRandom.current().nextInt(97, 123)));
                    break;
            }
        }
        return builder.toString();
    }

}

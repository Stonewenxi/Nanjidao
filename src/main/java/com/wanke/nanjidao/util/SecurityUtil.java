package com.wanke.nanjidao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * *******************************************
 * Author: 56
 * Data:   3/20/16 10:39 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:安全工具类,实现加密解密
 */
public class SecurityUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/20/16 10:41 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 加密
     */
    public static String encrypt(String inStr) {
        if (StringUtil.isEmpty(inStr)) {
            return null;
        }

        char[] ans = inStr.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) (ans[i] ^ 'z');
        }
        return new String(ans);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/20/16 10:42 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 解密
     */
    public static String dencrypt(String inStr) {
        if (StringUtil.isEmpty(inStr)) {
            return null;
        }

        char[] ans = inStr.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) (ans[i] ^ 't');
        }
        return new String(ans);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/20/16 10:43 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: MD5加密
     */
    public static String parseStrToMd5L32(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuilder stringBuffer = new StringBuilder();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 12:52 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: SHA1加密
     */
    public static String parseStrToSHA1(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }

        String resStr = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] bytes = sha1.digest(str.getBytes());
            int j = bytes.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            resStr = new String(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resStr;
    }
}

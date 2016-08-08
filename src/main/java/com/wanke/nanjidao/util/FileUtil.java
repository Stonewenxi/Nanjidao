package com.wanke.nanjidao.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * *******************************************
 * Author: 56
 * Data:   3/17/16 11:22 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:文件存储
 */
public class FileUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/17/16 11:26 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 存储文件,返回文件名
     *
     * @param file     存储的文件
     * @param basePath 文件包路径
     * @return 存储的文件名
     */
    public static String saveFile(MultipartFile file, String basePath, String name) {
        String res = "";
        File newFile = new File(basePath, name);
        OutputStream out = null;
        try {
            out = new FileOutputStream(newFile);
            byte[] buffer = file.getBytes();
            out.write(buffer, 0, buffer.length);
            out.flush();
            res = name;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/23/16 4:36 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 字符串存储
     */
    public static void saveJson(String jsonStr, String basePath, String name) {
        File newFile = new File(basePath, name);
        OutputStream out = null;
        try {
            out = new FileOutputStream(newFile);
            byte[] buffer = jsonStr.getBytes("utf8");
            out.write(buffer, 0, buffer.length);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

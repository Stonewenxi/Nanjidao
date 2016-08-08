package com.wanke.nanjidao.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * *******************************************
 * Author: 56
 * Data:   3/22/16 2:38 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:日期相关
 */
public class TimeUtil {

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 2:41 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 开启定时任务
     *
     * @param runnable  定时执行的任务
     * @param initDelay 初始延时 单位 s
     * @param delay     定时间隔 单位 s
     */
    public static void startRegularTask(Runnable runnable, long initDelay, long delay) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(runnable, initDelay, delay, TimeUnit.SECONDS);
    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/22/16 3:14 PM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 获取当前时间的时间戳
     */
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

}

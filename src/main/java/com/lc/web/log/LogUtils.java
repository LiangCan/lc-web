/**
 * @Title: LogUtils.java
 * @Package com.yijucloud.iotlife.log
 * @Description: TODO(用一句话描述该文件做什么)
 * @author lichao
 * @date 2015-8-4 上午9:18:29
 * @version V1.0
 */
package com.lc.web.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogUtils
 * @Description: 系统日志帮助类
 * @author liangcan
 * @date 2014-8-4 上午9:18:29
 * @version 1.0
 */
public class LogUtils {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger("dlock_xinjihua");

    /**
     * @Title: isDebugEnabled
     * @Description: 判断日志级别
     * @return boolean true 日志级别为debug
     */
    public static boolean isDebugEnabled() {
        return LOG.isDebugEnabled();
    }

    /**
     * @Title: isInfoEnabled
     * @Description: 判断日志级别
     * @return boolean true 日志级别为info
     */
    public static boolean isInfoEnabled() {
        return LOG.isInfoEnabled();
    }

    /**
     * @Title: isErrorEnabled
     * @Description: 判断日志级别
     * @return boolean true 日志级别为error
     */
    public static boolean isErrorEnabled() {
        return LOG.isErrorEnabled();
    }

    public static void info(String msg) {
        LOG.info(msg);
    }

    public static void debug(String msg) {
        LOG.info(msg);
    }

    public static void error(String msg) {
        LOG.info(msg);
    }

    public static void info(String msg, Throwable t) {
        LOG.info(msg, t);
    }

    public static void debug(String msg, Throwable t) {
        LOG.debug(msg, t);
    }

    public static void error(String info, Throwable t) {
        LOG.error(info, t);
    }
}

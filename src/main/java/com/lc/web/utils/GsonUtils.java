/**
 * @Title: GsonUtils.java
 * @Package com.yijucloud.iotlife.util
 * @Description: json转换帮助类
 * @author Henry
 * @date 2015年7月28日 下午3:28:44
 * @version V1.0
 */
package com.lc.web.utils;

import com.google.gson.Gson;

/**
 * @version 1.0
 * @ClassName: GsonUtils
 * @Description: json转换帮助类
 * @date 2015年7月28日 下午3:28:44
 */
public class GsonUtils {
    /**
     * gson对象
     */
    private static Gson gs = new Gson();

    /**
     * @param @param  obj
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: toJSON
     * @Description: 对象转JSON字符串
     */
    public static String toJSON(Object obj) {
        return gs.toJson(obj);
    }

    /**
     * @param @param  obj
     * @param @param  t
     * @param @return 设定文件
     * @return T 返回类型
     * @throws
     * @Title: toObj
     * @Description: JSON字符串转对象
     */
    public static <T> T toObj(String obj, Class<T> t) {
            return gs.fromJson(obj, t);
    }
}

/**   
 * @Title: MessageKey.java 
 * @Package com.yijucloud.menu 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Henry  
 * @date 2015年7月28日 下午3:43:20 
 * @version V1.0   
 */
package com.lc.web;

/**
 * @ClassName: MessageKey
 * @Description: 返回错误key
 * @author lichao
 * @date 2015年7月28日 下午3:43:20
 * @version 1.0
 */
public interface MessageKey
{
    /** 未知系统错误  0 */
    String SYSTEM_ERROR = "system.error";

    /** 参数值错误 10001*/
    String PARAM_VALUE_INVALID = "valid.param_value_invalid";
    /** 参数长度错误 10001*/
    String PARAM_VALUE_LENGTH = "valid.param_value_length_error";
    /** 缺少必备参数  10001*/
    String MISS_REQUIRE_PARAM = "valid.require_param_miss";
    /** 参数格式错误  10002*/
    String PARAM_FORMAT_ERROR = "valid.param_format_error";

    /** token不存在或者已过期 10003 */
    String PARAM_TOKEN_ERROR = "valid.param_token_error";


    /** 数据不存在 20000*/
    String SERVICE_DATA_IS_NULL = "service.data_is_null";
    /** 数据已经存在 */
    String SERVICE_DATA_IS_NOT_NULL = "service.data_is_not_null";

    interface api{
        /** 没有权限 */
        String API_NOT_JURISDICTION = "api.not_jurisdiction";

    }
}

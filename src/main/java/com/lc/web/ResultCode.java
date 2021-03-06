/**   
 * @Title: ResultCode.java 
 * @Package com.yijucloud.menu 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Henry  
 * @date 2015年7月28日 下午3:42:50 
 * @version V1.0   
 */
package com.lc.web;

/**
 * @ClassName: ResultCode
 * @Description: 返回错误码
 * @author lichao
 * @date 2015年7月28日 下午3:42:50
 * @version 1.0
 */
public interface ResultCode
{
    /** 系统错误  */
    String SYSTEM_ERROR = "0";

    /** 参数值错误 */
    String PARAM_VALUE_INVALID = "10001";

    /** 参数格式错误 */
    String PARAM_FORMAT_ERROR = "10002";

    /** token不存在或者已过期 */
    String PARAM_TOKEN_ERROR = "10003";

    /** 数据不存在 */
    String SERVICE_DATA_IS_NULL = "20000";

    /** 数据已经存在 */
    String SERVICE_DATA_IS_NOT_NULL = "20001";

    interface api{
        /** 没有权限 */
        String API_NOT_JURISDICTION = "30000";

        /** 该手机号码已经存在 */
        String API_MOBILE_EXISTENCE = "30001";

        /** 帐号或者密码错误 */
        String API_MOBILE_OR_PASSWORD_ERROR = "30002";

        /** 校验码过期或者不存在 */
        String API_CHECK_CODE_ERROR = "30003";

        /** 设备已经被绑定了 */
        String API_DEVICE_IS_BINDING = "30004";

        /** 找不到该用户的登录信息 */
        String API_USER_NOT_LOGIN = "30005";

        /** 设备不存在 */
        String API_DEVICE_NOT_EXISTENCE = "30006";

        /** 用户未绑定设备 */
        String API_USER_NOT_BINDING_DEVICE = "30007";

        /** 号码不存在 */
        String API_MOBILE_NOT_EXISTENCE = "30008";

        /** 房间不存在 */
        String API_ROOM_NOT_EXISTENCE = "30009";

        /** 已经分享过给该用户了 */
        String API_ALREADY_SHARE = "30010";

        /** 家庭不存在 */
        String API_HOME_NOT_EXISTENCE = "30011";

        /** 积分不足 Integral insufficient */
        String API_INTEGRAL_INSUFFICIENT = "30012";

        /** 订单不存在或者已经撤销 */
        String API_WORK_ORDER_NOT_EXISTENCE = "30013";

        /** 任务不存在或者已经撤销 */
        String API_TASK_NOT_EXISTENCE = "30014";

        /** 场景不存在 */
        String API_SCENE_NOT_EXISTENCE = "30015";
    }
}

/**
 * @Title: Constants.java
 * @Package com.yijucloud.menu
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Henry
 * @date 2015年7月28日 下午2:11:54
 * @version V1.0
 */
package com.lc.web;



public interface Constants
{


    /** 终端类型 */
     interface deviceType {
        /** PC */
         short PC = 1;
        /** WEB */
        short WEB = 2;
        /** ANDROID */
        short ANDROID = 3;
        /** IOS */
       short IOS = 4;
    }

    /** 用户属性名 */
    interface userProtocol{

        /** 用户ID */
        String USER_ID = "userId";

    }


    /** 服务端通用主状态 */
    interface mainStatus{
        /** 成功 */
        int SUCCESS = 1;

        /** 失败 */
        int FAIL = 9;

        /** 未知 */
        int UNKNOWN = 0;

        String SYSTEM_ERROR = "系统异常";

        String REQUEST_SUCCESS = "请求成功";
    }

    /** 校验码类型 */
    interface checkCodeType{
        /** 注册用户校验码 */
        Short RISTER = 1;

    }

    /** 主协议参数 */
    interface masterProtocol{
        /** 用户操作凭证 token */
        String TOKEN = "token";

        /** 请求必备参数 KEY (请求来源) */
        String KEY = "key";

        /**  协议版本  */
        String AGREEMENT_VERSION = "agreementVersion";

        /**  用户ID  */
        String USER_ID = "userId";

        /**  日志流水号  */
        String UUID = "uuid";

        /** 接口代码  */
        String FUN_CODE = "funCode";

        /**  接口名 */
        String FUNNAME = "funName";

        /**  接口版本  */
        String FUN_VERSION = "funVersion";

        /** 请求来源  */
        String REQ_TYPE = "reqType";

        /**  最终状态（1成功 9失败 0未知） */
        String STATUS = "status";

        /** 请求参数 */
        String REQUEST = "requestData";

        /** 返回参数  */
        String RESPONSE_DATA = "responseData";

        /**  请求时间  */
        String REQUESAT_TIME = "requestTime";

        /** 接收时间  */
        String CREATE_TIME = "createTime";

        /**  响应时间 */
        String RESPONSE_TIME = "responseTime";


    }

    /** ID前缀 */
    interface idPrefix{

        /** 校验码的 ID 前缀*/
        String CHECK_ID_PREFIX = "CK";

        /** 用户ID 前缀 */
        String USER_ID_PREFIX = "P";

        /** 用户群关系ID 前缀*/
        String NEXUS_GROUP_USER_PREFIX = "NG";

        /** 用户登录信息ID 前缀 */
        String USER_LOGIN_INFO_PREFIX = "UL";

        /** 用户申请入群表 */
        String USER_GROUP_APPLY_PREFIX= "UG";

        /** 关系表 */
        String USER_NOTICE_PREFIX = "UN";

        /** 用户关注表 */
        String USER_FOLLOW_PREFIX = "UF";

        /** 用户和群公告的关系表 */
        String USER_GROUP_NOTICE = "UGN";
    }

    /** http 前缀 */
    String HTTP_PREFIX = "http://";

    String PROJECT_NAME = "hhly_upload";

    /** 文件的保存目录 */
    String FILE_CATALOG = "/page/FileCataLog/";

    /**  默认编码  */
    String DEFAULT_ENCODE = "UTF-8";

    /** filter参数传递字段 */
    String TRANSMIT_PARAM = "fiterTransmit";

    /** 线程数量 */
    int NUMBER_OF_THREADS = 1;

    /** 服务器唯一ID */
    String SERVICE_ID = "10001";

    /** 默认公司代码 */
    String COMPANY_CODE = "C13322";

    /** 特殊符号*/
    interface specialSymbol{

        /** url分割线  */
        String URL_SEPARATE = "/";

        /** 逗号分割  */
        String COMMA = ",";

        /**  点  */
        String POINT = ".";

        /** 分号  */
        String SEMICOLON = ";";

        String COLOM = ":";

        String UNDERLINE = "_";

        String ADD="+";

    }
    /** 用户类型 */
    interface userType{

        short TEMPORARY = 1;

        short PERSONAL =2;

        short SILVER = 3;

        short GOLD = 4;

        short PLATINUM = 5;

        short DIAMOND = 6;

        short INVALID = 8;
    }

    interface pushMsgType{
        // 通知类型
        String MTP_6 = "6";

        //用户状态信息  强制退出
        String CONTENT_TYPE_105= "105";

        //有用户申请加入群
        String CONTENT_TYPE_401 = "401";

        //有群邀请用户加入群
        String CONTENT_TYPE_402 = "402";

        //用户收到处理结果
        String CONTENT_TYPE_403 = "403";

        //成员被踢通知
        String CONTENT_TYPE_404 = "404";

        // 群公告
        String CONTENT_TYPE_405 = "405";

        //成员收到组织结构更新
        String CONTENT_TYPE_203 = "203";

        //成员收到群成员状态更新
        String CONTENT_TYPE_205 = "205";

        //成员收到群成员职位更新
        String CONTENT_TYPE_206 = "206";

        //成员收到群失效
        String CONTENT_TYPE_209 = "209";


    }








}

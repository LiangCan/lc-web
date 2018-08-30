/**
 * @Title: ResponseDTO.java
 * @Package com.yijucloud.menu.dto
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Henry
 * @date 2015年7月28日 下午2:40:27
 * @version V1.0
 */
package com.lc.web.dto.resp;


import com.lc.web.Constants;

/**
 * 统一的返回参数DTO
 * version : 1.0
 */
public class ResponseDTO {
    /** 返回状态码 默认为0  */
    private String resultCode = String.valueOf(Constants.mainStatus.UNKNOWN);

    /** 返回json数据 */
    private Object data;

    /**  错误信息 */
    private String errorMsg = Constants.mainStatus.SYSTEM_ERROR;

    public ResponseDTO() {
    }

    /** 请求成功赋值 */
    public ResponseDTO(Object data) {
        this.resultCode = String.valueOf(Constants.mainStatus.SUCCESS);
        this.errorMsg = null;
        this.data = data;
    }

    /** 请求失败的赋值 */
    public ResponseDTO(String resultCode, String errorMsg){
        this.data = null;
        this.resultCode = resultCode;
        this.errorMsg = errorMsg;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        if(String.valueOf(Constants.mainStatus.SUCCESS).equals(resultCode)){
            this.resultCode = null;
            this.errorMsg = null;
        }
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        resultCode = String.valueOf(Constants.mainStatus.FAIL);
        this.errorMsg = errorMsg;
    }


}

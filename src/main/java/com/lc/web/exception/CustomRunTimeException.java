package com.lc.web.exception;

import com.lc.web.MessageKey;
import com.lc.web.ResultCode;
import com.lc.web.utils.ServiceUtils;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;

@SuppressWarnings("serial")
public class CustomRunTimeException extends RuntimeException {

    private static final Logger logger = Logger.getLogger(CustomRunTimeException.class);
    private String errorCode;
    private String errorMsg;
    private String errorDetail;
    private Exception exception;
    private Object result;

    public CustomRunTimeException() {

    }

    /** service层调用 */
    public CustomRunTimeException(String errorCode) {
        super();
        this.errorCode = errorCode;

        logger.error(String.format("errorCode【%s】", errorCode));
    }


    public CustomRunTimeException(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = ServiceUtils.messageUtils.getMessage(errorMsg);
        logger.error(String.format("errorCode【%s】errorMsg【%s】", errorCode, this.errorMsg ));
    }

    public CustomRunTimeException(String errorCode, String errorMsg, Object[] objNames) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = ServiceUtils.messageUtils.getMessage(errorMsg,objNames);
        logger.error(String.format("errorCode【%s】errorMsg【%s】", errorCode, this.errorMsg ));

    }

    public CustomRunTimeException(String errorCode, String errorMsg, String errorDetail) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorDetail = errorDetail;

        logger.error(String.format("errorCode【%s】errorMsg【%s】errorDetail【%s】", errorCode, errorMsg, errorDetail));
    }

    public CustomRunTimeException(String errorCode, Object result) {
        super();
        this.errorCode = errorCode;
        this.result = result;
        logger.error(String.format("errorCode【%s】", errorCode));
        printMessage(result);
    }

    public CustomRunTimeException(String errorCode, String errorMsg, Exception exception) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.exception = exception;

        logger.error(String.format("errorCode【%s】errorMsg【%s】detail【%s】", errorCode, errorMsg, exception.getMessage()));
        printMessage(exception);
    }



    public CustomRunTimeException(String errorCode, String errorMsg, Object result, String errorDetail) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorDetail = errorDetail;
        this.result = result;

        logger.error(String.format("errorCode【%s】errorMsg【%s】errorDetail【%s】", errorCode, errorMsg, errorDetail));
        printMessage(result);
    }

    private void printMessage(Object result) {
        if (null != result) {
            if (result instanceof Exception)
                logger.error(String.format("exception【%s】", getStackMsg((Exception) result)));
            else
                logger.error(String.format("result【%s】", result.toString()));
        }
    }

    private String getStackMsg(Exception e) {
        StringBuffer sb = new StringBuffer();
        sb.append(e.toString()).append("\n");
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }

    private String getStackMsg(Throwable e) {
        StringBuffer sb = new StringBuffer();
        sb.append(e.toString()).append("\n");
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public Throwable fillInStackTrace() {

        return super.fillInStackTrace();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }



    public static void checkNull(Object object, String objName){
        if(object == null){
            throw new CustomRunTimeException(ResultCode.SERVICE_DATA_IS_NULL, MessageKey.SERVICE_DATA_IS_NULL, new Object[]{objName});
        }
    }

    public static void checkIsNotNull(Object object, String objName){
        if(object != null){
            throw new CustomRunTimeException(ResultCode.SERVICE_DATA_IS_NOT_NULL, MessageKey.SERVICE_DATA_IS_NOT_NULL, new Object[]{objName});
        }
    }

    public static void vaildPram(BindingResult bindingResult){
        //校验参数
        if (bindingResult.hasErrors()) {
            throw new CustomRunTimeException(ResultCode.PARAM_VALUE_INVALID, bindingResult.getFieldError().getDefaultMessage(), new Object[]{bindingResult.getFieldError().getField()});
        }
    }

    public static void pramError(Object object, String  name){
        if(object == null){
            throw new CustomRunTimeException(ResultCode.PARAM_VALUE_INVALID, MessageKey.PARAM_VALUE_INVALID, new Object[]{name});
        }
    }
}
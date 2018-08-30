package com.lc.web.exception;



import com.lc.web.Constants;
import com.lc.web.MessageKey;
import com.lc.web.ResultCode;
import com.lc.web.dto.resp.ResponseDTO;
import com.lc.web.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice(basePackages={"com.lc.web.controller"})
public class GlobalExceptionHandler {

    @Autowired
    MessageUtils messageUtils;

    @ExceptionHandler(Exception.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseDTO exceptionHandler(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        ResponseDTO responseDTO = new ResponseDTO(String.valueOf(Constants.mainStatus.FAIL), Constants.mainStatus.SYSTEM_ERROR);
        return responseDTO;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseDTO httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletResponse response){
        ResponseDTO responseDTO = new ResponseDTO(ResultCode.PARAM_FORMAT_ERROR, messageUtils.getMessage(MessageKey.PARAM_FORMAT_ERROR, new Object[] {"json"}));
        return responseDTO;
    }

    @ExceptionHandler(CustomRunTimeException.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseDTO exceptionHandler(CustomRunTimeException e, HttpServletResponse response) {
        ResponseDTO responseDTO = new ResponseDTO(e.getErrorCode(), e.getErrorMsg());
        return responseDTO;
    }
}

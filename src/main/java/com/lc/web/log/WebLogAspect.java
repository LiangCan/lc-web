package com.lc.web.log;


import com.lc.web.Constants;
import com.lc.web.MessageKey;
import com.lc.web.ResultCode;
import com.lc.web.dto.BaseDTO;
import com.lc.web.pojo.ServiceLog;
import com.lc.web.service.ServiceLogService;
import com.lc.web.utils.StringUtil;
import com.lc.web.exception.CustomRunTimeException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {



    @Autowired
    ServiceLogService serviceLogService;

    private final static String SERVICE_LOG = "serviceLog";

    @Pointcut("execution(public * com.lc.web.controller..*.*(..))")
    public void reqLog() {
    }

    @Before("reqLog()")
    /**请求拦截处理 用于拦截service层记录异常日志 */
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ServiceLog serviceLog = new ServiceLog();
        serviceLog.setCreateTime(System.currentTimeMillis());
        serviceLog.setItfName(request.getRequestURI());
        serviceLog.setReqData(Arrays.toString(joinPoint.getArgs()));
        serviceLog.setReqIp(request.getRemoteAddr());

        Object[] pram = joinPoint.getArgs();
        BaseDTO baseDTO = new BaseDTO();

        baseDTO = (BaseDTO) pram[0];
        if (!StringUtil.isBlank(baseDTO.getKey()) || !StringUtil.isBlank(baseDTO.getRequestTime())) {
            serviceLog.setKey(baseDTO.getKey());
            try {
                serviceLog.setReqTime(Long.parseLong(baseDTO.getRequestTime()));
            } catch (NumberFormatException e) {
                throw new CustomRunTimeException(ResultCode.PARAM_VALUE_INVALID, MessageKey.PARAM_VALUE_INVALID, new Object[]{"requestTime"});
            } catch (Exception e) {
                throw new CustomRunTimeException(ResultCode.SYSTEM_ERROR, MessageKey.SYSTEM_ERROR);
            }
        }
        request.setAttribute(SERVICE_LOG, serviceLog);
        // 记录下请求内容
        LogUtils.info("URL : " + request.getRequestURL().toString());
        LogUtils.info("PARM : " + Arrays.toString(joinPoint.getArgs()));

    }

    /**
     * 返回正常 用于拦截service层记录异常日志
     */
    @AfterReturning(returning = "ret", pointcut = "reqLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ServiceLog serviceLog = (ServiceLog) request.getAttribute(SERVICE_LOG);
        serviceLog.setHandelStatus((short) Constants.mainStatus.SUCCESS);
        serviceLog.setReturnData(ret.toString());
        serviceLog.setReturnTime(System.currentTimeMillis());
        serviceLogService.addServiceLog(serviceLog);
        LogUtils.info(serviceLog.getItfName() + " RESPONSE : " + ret);
    }

}
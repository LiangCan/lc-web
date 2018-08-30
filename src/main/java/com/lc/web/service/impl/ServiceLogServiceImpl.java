package com.lc.web.service.impl;


import com.lc.web.MessageKey;
import com.lc.web.ResultCode;
import com.lc.web.pojo.ServiceLog;
import com.lc.web.repository.ServiceLogRepository;
import com.lc.web.service.ServiceLogService;
import com.lc.web.exception.CustomRunTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional( propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT, rollbackFor = CustomRunTimeException.class)
public class ServiceLogServiceImpl implements ServiceLogService {

    @Autowired
    ServiceLogRepository serviceLogRepository;


    @Override
    public void addServiceLog(ServiceLog serviceLog) {
        try{
            serviceLogRepository.save(serviceLog);
        }catch (Exception e){
            throw new CustomRunTimeException(ResultCode.SYSTEM_ERROR, MessageKey.SYSTEM_ERROR, new Object[]{"serviceLogRepository.save"});
        }
    }
}

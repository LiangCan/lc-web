package com.lc.web.service.impl;


import com.lc.web.Constants;
import com.lc.web.dto.req.UserLoginDTO;
import com.lc.web.dto.req.UserRegisterDTO;
import com.lc.web.dto.resp.ResponseDTO;
import com.lc.web.exception.CustomRunTimeException;
import com.lc.web.pojo.UserInfo;
import com.lc.web.repository.UserinfoRepository;
import com.lc.web.service.TPeriodService;
import com.lc.web.service.UserInfoService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = CustomRunTimeException.class)
public class TPeriodServiceImpl implements TPeriodService {

    @Autowired
    UserinfoRepository userinfoRepository;


    @Override
    public ResponseDTO pageQuery() {
        return null;
    }
}

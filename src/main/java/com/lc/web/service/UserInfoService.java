package com.lc.web.service;


import com.lc.web.dto.req.UserLoginDTO;
import com.lc.web.dto.req.UserRegisterDTO;
import com.lc.web.dto.resp.ResponseDTO;

/**
 * Created by Liang on 2016/12/23.
 */
public interface UserInfoService {

    /** API 用户登陆* */
    ResponseDTO userLogin(UserLoginDTO userLoginDTO);

    /** API 用户注册* */
    ResponseDTO userRigrster(UserRegisterDTO userRegisterDTO);


}

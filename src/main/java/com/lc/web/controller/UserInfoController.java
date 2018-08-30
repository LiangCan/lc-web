package com.lc.web.controller;

import com.lc.web.dto.req.UserLoginDTO;
import com.lc.web.dto.req.UserRegisterDTO;
import com.lc.web.utils.GsonUtils;
import com.lc.web.exception.CustomRunTimeException;
import com.lc.web.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Liang on 2017/4/13.
 */

@RestController
@Api(description="用户")
@RequestMapping(value = "/user")
public class UserInfoController {


    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value="用户登陆")
    @RequestMapping(value="/login.do", method = RequestMethod.POST)
    public String userLogin(@RequestBody @Valid UserLoginDTO userLoginDTO, BindingResult bindingResult) throws CustomRunTimeException {
        CustomRunTimeException.vaildPram(bindingResult);
        return GsonUtils.toJSON(userInfoService.userLogin(userLoginDTO));
    }

    @ApiOperation(value="用户注册")
    @RequestMapping(value="/regrster.do", method = RequestMethod.POST)
    public String userRigrster(@RequestBody @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) throws CustomRunTimeException {
        CustomRunTimeException.vaildPram(bindingResult);
        return GsonUtils.toJSON(userInfoService.userRigrster(userRegisterDTO));
    }
}

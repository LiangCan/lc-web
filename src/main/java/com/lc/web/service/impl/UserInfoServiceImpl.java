package com.lc.web.service.impl;


import com.lc.web.Constants;
import com.lc.web.dto.req.UserLoginDTO;
import com.lc.web.dto.req.UserRegisterDTO;
import com.lc.web.dto.resp.ResponseDTO;
import com.lc.web.exception.CustomRunTimeException;
import com.lc.web.pojo.UserInfo;
import com.lc.web.repository.UserinfoRepository;
import com.lc.web.service.UserInfoService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = CustomRunTimeException.class)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserinfoRepository userinfoRepository;


    @Override
    public ResponseDTO userLogin(UserLoginDTO userLoginDTO) {
        Long uid = userinfoRepository.findUidByQQ(userLoginDTO.getUser_qq());
        CustomRunTimeException.pramError(uid,"账号");
        UserInfo userInfo =  userinfoRepository.findUserByQQAndPad(userLoginDTO.getUser_qq(), userLoginDTO.getUser_password());
        CustomRunTimeException.pramError(userInfo,"密码");
        return new ResponseDTO(userInfo);
    }

    @Override
    public ResponseDTO userRigrster(UserRegisterDTO userRegisterDTO) {
        UserInfo userInfo = new UserInfo();

        if(!TextUtils.isEmpty(userRegisterDTO.getRecommend_user())){
            Long uid = userinfoRepository.findUidByQQ(userRegisterDTO.getRecommend_user());
            CustomRunTimeException.pramError(uid,"推荐用户");
            userInfo.setRecommend_user(uid);
        }

        Long uid = userinfoRepository.findUidByQQ(userRegisterDTO.getUser_qq());
        CustomRunTimeException.checkIsNotNull(uid,"账号");
        userInfo.setIntegral(0);
        userInfo.setUser_name(userRegisterDTO.getUser_name());
        userInfo.setUser_qq(userRegisterDTO.getUser_qq());
        userInfo.setUser_password(userRegisterDTO.getUser_password());
        userinfoRepository.save(userInfo);
        return new ResponseDTO(Constants.mainStatus.REQUEST_SUCCESS);
    }
}

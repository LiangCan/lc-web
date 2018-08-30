package com.lc.web.dto.req;


import com.lc.web.dto.BaseDTO;
import com.lc.web.MessageKey;
import com.lc.web.utils.RegularExpressionUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * ID DTO
 */
@ApiModel
public class UserRegisterDTO extends BaseDTO {
    @Length(max = 32, min = 2, message = MessageKey.PARAM_VALUE_LENGTH)
    @Pattern(regexp= RegularExpressionUtils.REGEX_NUMBER , message=MessageKey.PARAM_VALUE_INVALID )
    @ApiModelProperty(example = "386740444",  value = "用户名称")
    private String user_name;

    @NotEmpty(message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(max = 11, min = 6, message = MessageKey.PARAM_VALUE_LENGTH)
    @Pattern(regexp= RegularExpressionUtils.REGEX_NUMBER , message=MessageKey.PARAM_VALUE_INVALID )
    @ApiModelProperty(example = "386740444", required = true , value = "qq")
    private String user_qq;

    @NotEmpty(message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(max = 32, min = 6, message = MessageKey.PARAM_VALUE_LENGTH)
    @ApiModelProperty(example = "123456", required = true , value = "密码")
    private String user_password;

    @Length(max = 32, min = 6, message = MessageKey.PARAM_VALUE_LENGTH)
    @ApiModelProperty(example = "386740443", required = true , value = "推荐人")
    private String  recommend_user;

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRecommend_user() {
        return recommend_user;
    }

    public void setRecommend_user(String recommend_user) {
        this.recommend_user = recommend_user;
    }
}

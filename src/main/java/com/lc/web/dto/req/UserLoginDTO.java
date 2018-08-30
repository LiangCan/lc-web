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
public class UserLoginDTO extends BaseDTO {
    @NotEmpty(message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(max = 11, min = 6, message = MessageKey.PARAM_VALUE_LENGTH)
    @Pattern(regexp= RegularExpressionUtils.REGEX_NUMBER , message=MessageKey.PARAM_VALUE_INVALID )
    @ApiModelProperty(example = "386740444", required = true , value = "qq")
    private String user_qq;

    @NotEmpty(message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(max = 32, min = 6, message = MessageKey.PARAM_VALUE_LENGTH)
    @ApiModelProperty(example = "123456", required = true , value = "密码")
    private String user_password;

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
}

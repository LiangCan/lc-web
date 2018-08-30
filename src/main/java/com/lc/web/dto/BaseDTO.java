package com.lc.web.dto;


import com.lc.web.MessageKey;
import com.lc.web.utils.RegularExpressionUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel
public class BaseDTO  {

    @NotNull( message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(min=5, max =5, message= MessageKey.PARAM_VALUE_LENGTH)
    @Pattern(regexp= RegularExpressionUtils.REGEX_NUMBER , message=MessageKey.PARAM_VALUE_INVALID )
    @ApiModelProperty(example = "10000", required =true, value = "请求源KEY 长度固定5")
    private String  key;

    @NotNull( message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(min=13, max =13, message= MessageKey.PARAM_VALUE_LENGTH)
    @ApiModelProperty(example = "1660927290321", required =true, value="请求时间 长度固定13")
    @Pattern(regexp= RegularExpressionUtils.REGEX_NUMBER , message=MessageKey.PARAM_VALUE_INVALID )
    private String requestTime;

    public BaseDTO() {
    }

    public BaseDTO(String key, String requestTime) {
        this.key = key;
        this.requestTime = requestTime;
    }

    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public String getRequestTime() {
        return requestTime;
    }


    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "key='" + key + '\'' +
                ", requestTime='" + requestTime + '\'' +
                '}';
    }
}

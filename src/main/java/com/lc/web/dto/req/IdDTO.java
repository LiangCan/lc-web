package com.lc.web.dto.req;



import com.lc.web.MessageKey;
import com.lc.web.dto.BaseDTO;
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
public class IdDTO extends BaseDTO {

    @NotEmpty(message = MessageKey.MISS_REQUIRE_PARAM)
    @Length(max = 16, min = 1, message = MessageKey.PARAM_VALUE_LENGTH)
    @ApiModelProperty(example = "1", value = "ID")
    @Pattern(regexp = RegularExpressionUtils.REGEX_NUMBER, message = MessageKey.PARAM_VALUE_INVALID)
    private String id;

    public Long getId() {
        return Long.parseLong(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "IdDTO{ " +
                " id= " + id +
                "}" ;
    }
}

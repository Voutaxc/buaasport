package com.buaasport.competition.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="忘记密码对象")
public class ForgetVo {


    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String newpassword;

    @ApiModelProperty(value = "验证码")
    private String code;
}

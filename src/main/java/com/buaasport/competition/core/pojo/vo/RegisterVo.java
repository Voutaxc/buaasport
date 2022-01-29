package com.buaasport.competition.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="注册对象")
public class RegisterVo {

    @ApiModelProperty(value = "用户类型")
    private Integer auth;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String code;
}

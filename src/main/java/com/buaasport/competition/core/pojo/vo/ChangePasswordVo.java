package com.buaasport.competition.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="修改密码对象")
public class ChangePasswordVo {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户权限")
    private Integer auth;

    @ApiModelProperty(value = "密码")
    private String oldpassword;

    @ApiModelProperty(value = "验证码")
    private String newpassword;
}

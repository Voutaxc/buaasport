package com.buaasport.competition.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="用户信息对象")
public class UserInfoVo {

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "5：总管理 4：组委会 3：领队 2：裁判")
    private Integer auth;

    @ApiModelProperty(value = "JWT访问令牌")
    private String token;
}

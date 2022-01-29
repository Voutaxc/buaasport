package com.buaasport.competition.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="历史成绩对象")
public class HistoryScoreVo {
    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "比赛类型")
    private String gameType;
}

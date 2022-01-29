package com.buaasport.competition.core.controller;


import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.R;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.service.AthleteService;
import com.buaasport.competition.core.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "运动员接口")
@RestController
@RequestMapping("/api/core/athlete")
@Slf4j
@CrossOrigin
public class AthleteController {

    @Resource
    private AthleteService athleteService;

    @Resource
    private RedisTemplate redisTemplate;



    @ApiOperation("信息上传")
    @PostMapping("/uploadInfo")
    public R createTeam(@RequestBody AthleteInfo athleteInfo){

        //Assert.notEmpty(teamname, ResponseEnum.TEAMNAME_NULL_ERROR);
        //注册
        return R.ok().message("创建成功");
    }

    @ApiOperation("获取运动员信息")
    @PostMapping("/getAthleteInfo")
    public R createTeam(@RequestBody Long userid){

        //Assert.notEmpty(teamname, ResponseEnum.TEAMNAME_NULL_ERROR);
        //注册

        return R.ok().data("athleteInfo", athleteService.getAthleteInfo(userid));
    }



    @ApiOperation("信息修改")
    @PostMapping("/updateInfo")
    public R listTeamMember(@RequestBody Team team){

        String teamname = team.getTeamName();

        Assert.notEmpty(teamname, ResponseEnum.TEAMNAME_NULL_ERROR);


        //注册
       // teamService.createTeam(team);
        return R.ok().message("创建成功");
    }

    @ApiOperation("赛事报名")
    @PostMapping("/apply")
    public R apply(@RequestBody Team team){

        String teamname = team.getTeamName();

        Assert.notEmpty(teamname, ResponseEnum.TEAMNAME_NULL_ERROR);


        //注册
        // teamService.createTeam(team);
        return R.ok().message("创建成功");
    }
}


package com.buaasport.competition.core.controller;


import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.R;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.core.pojo.entity.AthleteApplyForm;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;
import com.buaasport.competition.core.repositories.AthleteApplyFormRepository;
import com.buaasport.competition.core.repositories.AthleteRepository;
import com.buaasport.competition.core.repositories.TeamRepository;
import com.buaasport.competition.core.service.AthleteService;
import com.buaasport.competition.core.service.TeamService;
import com.buaasport.competition.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Api(tags = "团队接口")
@RestController
@RequestMapping("/api/core/team")
@Slf4j
@CrossOrigin
public class TeamController {

    @Resource
    private TeamService teamService;

    @Resource
    private AthleteService athleteService;

    @Resource
    private AthleteApplyFormRepository athleteapplyFormRepository;

    @Resource
    private AthleteRepository athleteRepository;

    @Resource
    private TeamRepository teamRepository;



    @ApiOperation("团队创建")
    @PostMapping("/createTeam")
    public R createTeam(@RequestBody Team team){

        String teamname = team.getTeamName();

        Assert.notEmpty(teamname, ResponseEnum.TEAMNAME_NULL_ERROR);


        //注册
        teamService.createTeam(team);
        return R.ok().message("创建成功");
    }

    @ApiOperation("查看团队成员列表")
    @GetMapping("/listTeamMember/{teamId}")
    public R listTeamMember(@PathVariable Long teamId){

        return R.ok().data("memberlist", teamService.getTeamMember(teamId));
    }

    @ApiOperation("查看比赛申请列表")
    @GetMapping("/listApplyMember/{teamId}")
    public R showMember(@PathVariable Long teamId){
        return R.ok().data("teamapply", teamService.getTeamApplyForm(teamId));
    }

    @ApiOperation("查看团队项目类型")
    @GetMapping("/getTeamInfo/{userId}")
    public R getGameType(@PathVariable Long userId){
        return R.ok().data("teaminfo", teamService.getTeamInfoByLeaderId(userId));
    }




    @ApiOperation("导出成员列表")
    @GetMapping("/exportTeamInfo")
    public R exportTeamInfo(@RequestBody Team team){

        return R.ok().message("导出成功");
    }

    @ApiOperation("批准报名")
    @PostMapping("/approveSign")
    public R approveSign(@RequestBody Long applyId){
        AthleteApplyForm a = athleteapplyFormRepository.findByApplyFormId(applyId);
        Long teamId = a.getTeamId();
        Team t = teamService.getTeamInfoByTeamId(teamId);
        AthleteInfo ai = athleteService.getAthleteInfo(a.getUserId());
        t.getAthletes().add(ai);
        teamRepository.save(t);
        athleteapplyFormRepository.delete(a);
        return R.ok().message("通过成功");
    }


    @ApiOperation("撤销报名")
    @PostMapping("/declineSign")
    public R declineSign(@RequestBody Long applyId){

        AthleteApplyForm a = athleteapplyFormRepository.findByApplyFormId(applyId);
        athleteapplyFormRepository.delete(a);
        return R.ok().message("撤销报名成功");
    }
}


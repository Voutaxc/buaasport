package com.buaasport.competition.core.service.impl;

import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.common.util.MD5;
import com.buaasport.competition.core.pojo.entity.AthleteApplyForm;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;
import com.buaasport.competition.core.repositories.AthleteApplyFormRepository;
import com.buaasport.competition.core.repositories.TeamRepository;
import com.buaasport.competition.core.repositories.UserInfoRepository;
import com.buaasport.competition.core.service.TeamService;
import com.buaasport.competition.core.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
@Service
public class TeamServiceImpl implements TeamService {


    @Resource
    private TeamRepository teamRepository;

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private AthleteApplyFormRepository athleteApplyFormRepository;

    @Override
    public void createTeam(Team team) {
        Integer count = teamRepository.findByTeamName(team.getTeamName()).size();
        Assert.isTrue(count == 0, ResponseEnum.TEAMNAME_EXIST_ERROR);
        teamRepository.save(team);
    }

    @Override
    public List<AthleteInfo> getTeamMember(Long teamid) {
//        List<Long> an = userInfoRepository.findByTeamId(teamid);
        List<AthleteInfo> an = teamRepository.findByTeamId(teamid).getAthletes();
        return an;
    }

    @Override
    public List<AthleteApplyForm> getTeamApplyForm(Long userid) {
        return athleteApplyFormRepository.findByTeamId(userid);
    }

    @Override
    public Team getTeamInfoByLeaderId(Long userid) {
        Team team =teamRepository.findByLeaderId(userid);
        return team;
    }

    @Override
    public Team getTeamInfoByTeamId(Long teamid) {
        return teamRepository.findByTeamId(teamid);
    }


}

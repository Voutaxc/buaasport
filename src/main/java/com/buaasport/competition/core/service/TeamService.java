package com.buaasport.competition.core.service;

import com.buaasport.competition.core.pojo.entity.AthleteApplyForm;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
public interface TeamService {

    void createTeam(Team team);
    List<AthleteInfo> getTeamMember(Long teamid);

    Team getTeamInfoByLeaderId(Long userid);

    Team getTeamInfoByTeamId(Long teamid);
    List<AthleteApplyForm> getTeamApplyForm(Long userid);

}

package com.buaasport.competition.core.service.impl;

import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.repositories.AthleteRepository;
import com.buaasport.competition.core.repositories.TeamRepository;
import com.buaasport.competition.core.service.AthleteService;
import com.buaasport.competition.core.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
@Service
public class AthleteServiceImpl implements AthleteService {


    @Resource
    private AthleteRepository athleterepository;


    @Override
    public void uploadInfo(AthleteInfo athleteInfo) {
       athleterepository.save(athleteInfo);
    }

    @Override
    public void updateInfo(AthleteInfo athleteInfo) {
        athleterepository.deleteById(athleteInfo.getUserId());
        athleterepository.save(athleteInfo);
    }

    @Override
    public AthleteInfo getAthleteInfo(Long userId) {
        return athleterepository.findByUserId(userId);
    }


}

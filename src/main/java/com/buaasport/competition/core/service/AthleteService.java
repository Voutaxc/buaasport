package com.buaasport.competition.core.service;

import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
public interface AthleteService {

    void uploadInfo(AthleteInfo athleteInfo);

    void updateInfo(AthleteInfo athleteInfo);

    AthleteInfo getAthleteInfo(Long userId);

}

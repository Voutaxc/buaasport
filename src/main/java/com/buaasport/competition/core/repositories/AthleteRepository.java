package com.buaasport.competition.core.repositories;

import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AthleteRepository extends PagingAndSortingRepository<AthleteInfo, Long> {
    AthleteInfo findByUserId(Long userId);

}

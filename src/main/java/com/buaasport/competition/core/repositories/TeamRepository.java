package com.buaasport.competition.core.repositories;

import com.buaasport.competition.core.pojo.entity.Team;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
     List<UserInfo> findByTeamName(String name);
     Team findByLeaderId(Long userId);

     Team findByTeamId(Long userId);


}

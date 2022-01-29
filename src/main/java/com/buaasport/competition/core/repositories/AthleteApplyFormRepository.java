package com.buaasport.competition.core.repositories;

import com.buaasport.competition.core.pojo.entity.AthleteApplyForm;
import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AthleteApplyFormRepository extends PagingAndSortingRepository<AthleteApplyForm, Long> {
    List<AthleteApplyForm> findByUserId(Long userId);
    List<AthleteApplyForm> findByTeamId(Long userId);
    AthleteApplyForm findByApplyFormId(Long applyId);
}

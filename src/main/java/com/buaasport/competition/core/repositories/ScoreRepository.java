package com.buaasport.competition.core.repositories;

import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Score;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreRepository extends PagingAndSortingRepository<Score, Long> {
    List<Score> findByUserId(Long userId);
    List<Score> findByUserIdAndGameType(Long userId, String gameType);
}

package com.buaasport.competition.core.service.impl;

import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Score;
import com.buaasport.competition.core.pojo.vo.HistoryScoreVo;
import com.buaasport.competition.core.repositories.AthleteRepository;
import com.buaasport.competition.core.repositories.ScoreRepository;
import com.buaasport.competition.core.service.AthleteService;
import com.buaasport.competition.core.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ScoreServiceImpl implements ScoreService {


    @Resource
    private ScoreRepository scoreRepository;


    @Override
    public List<Score> getScore(Long userId) {
        return scoreRepository.findByUserId(userId);
    }

    @Override
    public List<Score> getScoreByGame(HistoryScoreVo historyScoreVo) {
        String gameType = historyScoreVo.getGameType();
        Long userId = historyScoreVo.getUserId();
        return scoreRepository.findByUserIdAndGameType(userId, gameType);
    }

    @Override
    public void addScore(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public void changeScore(Score score) {

    }
}

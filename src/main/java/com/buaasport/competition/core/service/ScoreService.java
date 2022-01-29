package com.buaasport.competition.core.service;

import com.buaasport.competition.core.pojo.entity.AthleteInfo;
import com.buaasport.competition.core.pojo.entity.Score;
import com.buaasport.competition.core.pojo.vo.HistoryScoreVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
public interface ScoreService {

   List<Score> getScore(Long userId);

   List<Score> getScoreByGame(HistoryScoreVo historyScoreVo);

   void addScore(Score score);

   void changeScore(Score score);



}

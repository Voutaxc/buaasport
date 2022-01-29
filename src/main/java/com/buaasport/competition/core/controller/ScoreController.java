package com.buaasport.competition.core.controller;


import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.R;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.core.pojo.vo.HistoryScoreVo;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;
import com.buaasport.competition.core.service.ScoreService;
import com.buaasport.competition.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "成绩接口")
@RestController
@RequestMapping("/api/core/score")
@Slf4j
@CrossOrigin
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @Resource
    private RedisTemplate redisTemplate;



    @ApiOperation("历史成绩查询")
    @PostMapping("/getHistoryScore")
    public R getHistoryScore(@RequestBody Long userId){
        return R.ok().data("historyScore", scoreService.getScore(userId));
    }

    @ApiOperation("历史项目成绩查询")
    @PostMapping("/getHistoryGameScore")
    public R getHistoryGameScore(@RequestBody HistoryScoreVo historyScoreVo){

        return R.ok().data("historyScore", scoreService.getScoreByGame(historyScoreVo));
    }

    @ApiOperation("修改成绩")
    @PostMapping("/changeScore")
    public R changeScore(@RequestBody LoginVo loginVO){

//        String username = loginVO.getUsername();
//        String password =  loginVO.getPassword();
//
//        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);
//
//        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
//
//        //注册
//        userInfoService.login(loginVO);
        return R.ok().message("登录成功");

    }

    @ApiOperation("获取用户数据")
    @GetMapping("/getUserInfo")
    public R gerUserInfo(@RequestBody Long userid){
//        Assert.notEmpty(userid.toString(), ResponseEnum.USERID_NULL_ERROR);
        return R.ok();

    }

}


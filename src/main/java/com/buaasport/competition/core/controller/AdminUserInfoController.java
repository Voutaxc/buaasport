//package com.buaasport.competition.core.controller;
//
//
//import com.buaasport.competition.common.exception.Assert;
//import com.buaasport.competition.common.result.R;
//import com.buaasport.competition.common.result.ResponseEnum;
//import com.buaasport.competition.core.pojo.vo.LoginVo;
//import com.buaasport.competition.core.pojo.vo.RegisterVo;
//import com.buaasport.competition.core.service.UserInfoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
//@Api(tags = "用户接口")
//@RestController
//@RequestMapping("/api/core/userInfo")
//@Slf4j
//@CrossOrigin
//public class AdminUserInfoController {
//
//    @Resource
//    private UserInfoService userInfoService;
//
//    @Resource
//    private RedisTemplate redisTemplate;
//
//
//
//    @ApiOperation("用户注册")
//    @PostMapping("/register")
//    public R register(@RequestBody RegisterVo registerVO){
//
//        String username = registerVO.getUsername();
//        String password = registerVO.getPassword();
//        String email = registerVO.getEmail();
//        Integer auth = registerVO.getAuth();
//
//        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
//
//        Assert.notEmpty(email, ResponseEnum.EMAIL_NULL_ERROR);
//
//        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);
//
//
//        //注册
//        userInfoService.register(registerVO);
//        return R.ok().message("注册成功");
//    }
//
//    @ApiOperation("用户登录")
//    @PostMapping("/login")
//    public R login(@RequestBody LoginVo loginVO){
//
//        String username = loginVO.getUsername();
//        String password =  loginVO.getPassword();
//
//        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);
//
//        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
//
//        //注册
//        userInfoService.login(loginVO);
//        return R.ok().message("登录成功");
//    }
//
//}


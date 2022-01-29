package com.buaasport.competition.core.controller;


import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.R;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.common.util.MD5;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import com.buaasport.competition.core.pojo.vo.*;
import com.buaasport.competition.core.repositories.UserInfoRepository;
import com.buaasport.competition.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/api/core/userInfo")
@Slf4j
@CrossOrigin
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

   @Resource
   private   UserInfoRepository userInfoRepository;



    @ApiOperation("用户注册")
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVO){

        String username = registerVO.getUsername();
        String password = registerVO.getPassword();
        String email = registerVO.getPhone();
        Integer auth = registerVO.getAuth();

        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);

        Assert.notEmpty(email, ResponseEnum.EMAIL_NULL_ERROR);

        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);


        //注册
        userInfoService.register(registerVO);
        return R.ok().message("注册成功");
    }

//    @ApiOperation("领队注册")
//    @PostMapping("/register")
//    public R register(@RequestBody RegisterVo registerVO){
//
//        String username = registerVO.getUsername();
//        String password = registerVO.getPassword();
//        String email = registerVO.getPhone();
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

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVO, HttpServletRequest request){

        String username = loginVO.getUsername();
        String password =  loginVO.getPassword();
        int auth = loginVO.getAuth();

        Assert.notEquals(auth, -1, ResponseEnum.LOGIN_AUTH_ERROR);

        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);

        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);

        String ip = request.getRemoteAddr();
        UserInfoVo userInfoVO = userInfoService.login(loginVO, ip);
        //注册

        return R.ok().data("userInfo", userInfoVO);

    }

    @ApiOperation("获取用户数据")
    @GetMapping("/getUserInfo")
    public R gerUserInfo(@RequestBody Long userid){
        Assert.notEmpty(userid.toString(), ResponseEnum.USERID_NULL_ERROR);
        return R.ok().data("userinfo", userInfoService.getUserInfo(userid));

    }

    @ApiOperation("忘记密码")
    @PostMapping("/forget")
    public R forget(@RequestBody ForgetVo forgetVo){

        String username = forgetVo.getUsername();

        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);

        UserInfo userInfo = userInfoService.getUserInfoByName(username);



        userInfo.setPassword(MD5.encrypt(forgetVo.getNewpassword()));

        userInfoRepository.save(userInfo);

        return R.ok();

    }

    @ApiOperation("修改密码")
    @PostMapping("/changepassword")
    public R changepassword(@RequestBody ChangePasswordVo changePasswordVo){

        String username = changePasswordVo.getUsername();

        Integer auth = changePasswordVo.getAuth();



        UserInfo userInfo = userInfoRepository.findByUserNameAndAuth(username, auth);

        String password = changePasswordVo.getOldpassword();
        String newpassword = changePasswordVo.getNewpassword();

        Assert.equals(userInfo.getPassword(), MD5.encrypt(password), ResponseEnum.USERNAME_NULL_ERROR);

        userInfo.setPassword(MD5.encrypt(newpassword));

        userInfoRepository.save(userInfo);
        return R.ok();

    }

}


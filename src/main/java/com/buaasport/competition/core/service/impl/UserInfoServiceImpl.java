package com.buaasport.competition.core.service.impl;

import com.buaasport.competition.common.exception.Assert;
import com.buaasport.competition.common.result.ResponseEnum;
import com.buaasport.competition.common.util.JwtUtils;
import com.buaasport.competition.common.util.MD5;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;
import com.buaasport.competition.core.pojo.vo.UserInfoVo;
import com.buaasport.competition.core.repositories.UserInfoRepository;
import com.buaasport.competition.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserInfoServiceImpl  implements UserInfoService {


    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public void register(RegisterVo registerVO) {
       UserInfo ouserInfo = userInfoRepository.findByUserNameAndAuth(registerVO.getUsername(), 3);
        Assert.isTrue(ouserInfo != null, ResponseEnum.USERNAME_EXIST_ERROR);

        UserInfo userInfo = new UserInfo();
        userInfo.setAuth(registerVO.getAuth());
        userInfo.setPhone(registerVO.getPhone());
        userInfo.setPassword(MD5.encrypt(registerVO.getPassword()));
        userInfo.setUserName(registerVO.getUsername());

        userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfoVo login(LoginVo loginVo, String ip) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        Integer auth = loginVo.getAuth();
        UserInfo userInfo =  userInfoRepository.findByUserNameAndAuth(username, auth);
        System.out.println(userInfo.getPassword());
        Assert.notNull(userInfo , ResponseEnum.LOGIN_USERNAME_NOTEXIST_ERROR);


        Assert.equals(MD5.encrypt(password), userInfo.getPassword(), ResponseEnum.LOGIN_PASSWORD_ERROR);

        String token = JwtUtils.createToken(userInfo.getUserId(), userInfo.getUserName());
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setToken(token);
        userInfoVo.setName(userInfo.getUserName());

        userInfoVo.setPhone(userInfo.getPhone());
        userInfoVo.setAuth(auth);
        userInfoVo.setId(userInfo.getUserId());

        return userInfoVo;
    }

    @Override
    public UserInfo getUserInfo(Long userid) {

        return userInfoRepository.findById(userid).get();
    }

    @Override
    public UserInfo getUserInfoByName(String userName) {
        return userInfoRepository.findByUserName(userName);
    }


}

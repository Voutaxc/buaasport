package com.buaasport.competition.core.service;

import com.buaasport.competition.core.pojo.entity.UserInfo;
import com.buaasport.competition.core.pojo.vo.LoginVo;
import com.buaasport.competition.core.pojo.vo.RegisterVo;
import com.buaasport.competition.core.pojo.vo.UserInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-10-24
 */
public interface UserInfoService {

    void register(RegisterVo registerVO);
    UserInfoVo login(LoginVo loginVO, String ip);
    UserInfo getUserInfo(Long userid);
    UserInfo getUserInfoByName(String userName);
}

package com.buaasport.competition.core.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.buaasport.competition.core.pojo.entity.UserInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Long> {

    UserInfo findByUserNameAndAuth(String name, Integer auth);
    UserInfo findByUserName(String name);
}

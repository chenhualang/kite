package com.zhong.kite.repo;

import com.zhong.kite.dao.HaClaimCaseLevelDAO;
import com.zhong.kite.model.HaClaimCaseLevelDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HaClaimCaseLevelRepo {
    @Resource
    private HaClaimCaseLevelDAO haClaimCaseLevelDAO;

    public int saveHaClaimCaseLevel(HaClaimCaseLevelDO haClaimCaseLevelDO){
         return haClaimCaseLevelDAO.insert(haClaimCaseLevelDO);
    }


}

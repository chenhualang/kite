package com.zhong.kite.Impl;

import com.zhong.kite.HaClaimCaseLevelService;
import com.zhong.kite.model.HaClaimCaseLevelDO;
import com.zhong.kite.model.enums.ErrorCodeEnum;
import com.zhong.kite.model.util.BaseResult;
import com.zhong.kite.repo.HaClaimCaseLevelRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service
public class HaClaimCaseLevelServiceImpl implements HaClaimCaseLevelService {
    @Resource
    private HaClaimCaseLevelRepo haClaimCaseLevelRepo;

    public BaseResult<String> saveHaClaimCaseLevel(HaClaimCaseLevelDO haClaimCaseLevelDO){
        BaseResult<String> result = new BaseResult<>();
        if (haClaimCaseLevelDO == null) {
            log.warn("参数为空");
            result.setCode(ErrorCodeEnum.CMN_20001.getCode());
            result.setMessage("参数为空");
            return result;
        }
        haClaimCaseLevelRepo.saveHaClaimCaseLevel(haClaimCaseLevelDO);
        result.setCodeSuccess();
        return result;
    }
}

package com.zhong.kite;

import com.zhong.kite.model.HaClaimCaseLevelDO;
import com.zhong.kite.model.util.BaseResult;

public interface HaClaimCaseLevelService {
    public BaseResult<String> saveHaClaimCaseLevel(HaClaimCaseLevelDO haClaimCaseLevelDO);
}

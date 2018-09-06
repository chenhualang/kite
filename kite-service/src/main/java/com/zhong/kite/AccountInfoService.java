package com.zhong.kite;

import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.model.AccountInfoDTO;

import java.util.List;
import java.util.Map;

public interface AccountInfoService {
    public List<AccountInfoDO> getAccountInfoList(AccountInfoDTO accountInfo);

    public int addAccountInfo(AccountInfoDTO accountInfo) ;

    public int updateAccountInfo(AccountInfoDTO accountInfo);
}

package com.zhong.kite.Impl;

import com.zhong.kite.AccountInfoService;
import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.model.AccountInfoDTO;
import com.zhong.kite.repo.AccountInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Resource
    private AccountInfoRepo accountInfoRepo;

    public List<AccountInfoDO> getAccountInfoList(AccountInfoDTO accountInfo){
        List<AccountInfoDO> accountInfoList = new ArrayList<>();
        int offset = (accountInfo.getPageNo() - 1) * accountInfo.getPageSize();
        accountInfo.setOffset(offset);
        accountInfoList=accountInfoRepo.getAccountInfoList(accountInfo);
        return accountInfoList;
    }
    

    @Override
    public int addAccountInfo(AccountInfoDTO accountInfo) {
        return accountInfoRepo.addAccountInfo(accountInfo);
    }

    @Override
    public int updateAccountInfo(AccountInfoDTO accountInfo) {
        return accountInfoRepo.updateAccountInfo(accountInfo);
    }
    
}

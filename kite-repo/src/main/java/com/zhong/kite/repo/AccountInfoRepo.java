package com.zhong.kite.repo;

import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.mapper.AccountInfoDAO;
import com.zhong.kite.model.AccountInfoDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountInfoRepo {
    @Resource
    private AccountInfoDAO accountInfoDAO;

    public List<AccountInfoDO> getAccountInfoList(AccountInfoDTO accountInfoDTO){
        return accountInfoDAO.getAccountInfoList(accountInfoDTO);
    }

    public int addAccountInfo(AccountInfoDTO accountInfo){
        return accountInfoDAO.addAccountInfo(accountInfo);
    }

    public int updateAccountInfo(AccountInfoDTO accountInfoDTO) {
        return accountInfoDAO.updateAccountInfo(accountInfoDTO);
    }
}

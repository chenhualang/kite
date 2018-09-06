package com.zhong.kite.mapper;

import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.model.AccountInfoDTO;
import com.zhong.kite.model.UserDTO;

import java.util.List;

public interface AccountInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountInfoDTO record);

    int insertSelective(AccountInfoDTO record);

    AccountInfoDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountInfoDTO record);

    int updateByPrimaryKey(AccountInfoDTO record);


    List<AccountInfoDO> getAccountInfoList(AccountInfoDTO record);

    int addAccountInfo(AccountInfoDTO accountInfo);

    int updateAccountInfo(AccountInfoDTO accountInfo);
}
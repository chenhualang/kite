package com.zhong.kite.service.accountinfo;

import com.zhong.kite.AccountInfoService;
import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.model.AccountInfoDTO;
import com.zhong.kite.service.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class AccountInfoServiceTest extends BaseTest {
    @Resource
    AccountInfoService accountInfoService;

    @Test
    public void testAdd(){
        AccountInfoDTO accountInfo = new AccountInfoDTO();
        accountInfo.setNickname("chenhualang");
        accountInfo.setCellphone("15021662091");
        accountInfo.setMailAddress("1156929440@qq.com");
        accountInfo.setPassword("Chenhl1207");
        int i = accountInfoService.addAccountInfo(accountInfo);
        System.out.println("增加转运仓记录成功，结果为"+i);
    }

    @Test
    public void testUpdate(){
        AccountInfoDTO accountInfo = new AccountInfoDTO();
        accountInfo.setId(1);
        accountInfo.setNickname("tianyuan");
        accountInfo.setCellphone("15021612097");
        accountInfo.setMailAddress("1156929440@qq.com");
        accountInfo.setPassword("Chenhl1207");
        int i = accountInfoService.updateAccountInfo(accountInfo);
        System.out.println("更新转运仓成功，结果为"+i);
    }

    @Test
    public void testGetAccountInfoList(){
        AccountInfoDTO accountInfo = new AccountInfoDTO();
        accountInfo.setNickname("tianyuan");
        List<AccountInfoDO> accountInfoList = accountInfoService.getAccountInfoList(accountInfo);
        System.out.println("查询返回的结果为"+accountInfoList);
    }
}

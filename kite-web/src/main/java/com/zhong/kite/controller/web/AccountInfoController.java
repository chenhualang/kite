package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.AccountInfoService;
import com.zhong.kite.DO.AccountInfoDO;
import com.zhong.kite.controller.VO.AccountInfoVO;
import com.zhong.kite.model.AccountInfoDTO;
import com.zhong.kite.model.PackageInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/accountInfos")
@Controller
@Slf4j
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/getAccountInfos",method = RequestMethod.POST)
    @ResponseBody
    public List<AccountInfoDO> getAccountInfoList(@RequestBody AccountInfoVO accountInfoVO){
        AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
        BeanUtils.copyProperties(accountInfoVO,accountInfoDTO);
        log.info("请求参数为"+JSON.toJSONString(accountInfoDTO));
        List<AccountInfoDO> accountInfoList = accountInfoService.getAccountInfoList(accountInfoDTO);
        log.info("返回结果为:"+ JSON.toJSONString(accountInfoList));
        return accountInfoList;
    }

    @ResponseBody
    @RequestMapping("/updateAccountInfo.action")
    public int updateAccountInfo(@RequestParam("id")int uid,@RequestParam("pass")String pass){
        AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
        accountInfoDTO.setPassword(pass);
        accountInfoDTO.setId(uid);
        int i=accountInfoService.updateAccountInfo(accountInfoDTO);
        return i;
    }

    @ResponseBody
    @RequestMapping("/addAccountInfo.action")
    public int addAccountInfo(AccountInfoVO accountInfoVO){
        AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
        BeanUtils.copyProperties(accountInfoVO,accountInfoDTO);
        int i=accountInfoService.addAccountInfo(accountInfoDTO);
        return i;
    }


    /**
     * 用户登陆
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doLogin.action")
    public Map<String,Object> doLoginByAccount(AccountInfoVO user,HttpServletRequest request){
        Map<String,Object>map=new HashMap<String, Object>();
        Integer i=null;
        AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
        BeanUtils.copyProperties(user,accountInfoDTO);
        List<AccountInfoDO> accountInfoList = accountInfoService.getAccountInfoList(accountInfoDTO);
        if(accountInfoList!=null&&accountInfoList.size()>0){
            if(user.getPassword().equals(accountInfoList.get(0).getPassword())){
                i=0;//登陆成功
                request.getSession().setAttribute("ID", accountInfoList.get(0).getId());
                request.getSession().setAttribute("PASS", accountInfoList.get(0).getPassword());
            }else{
                i=1;//登录密码不正确
            }
        }else{
            i=2;//此账号不存在
        }
        map.put("i", i);
        return map;
    }


    /**
     * 修改用户密码
     * @param uid
     * @param pass
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/upPass.action")
    public int upPass(@RequestParam("id")int uid,@RequestParam("pass")String pass,HttpServletRequest request){
        AccountInfoDTO accountInfo = new AccountInfoDTO();
        accountInfo.setId(uid);
        accountInfo.setPassword(pass);
        int i=accountInfoService.updateAccountInfo(accountInfo);
        return i;
    }

}

package com.zhong.kite.controller.web;

import com.zhong.kite.model.HaClaimCaseLevelDO;
import com.zhong.kite.model.util.BaseResult;
import com.zhong.kite.HaClaimCaseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/caseLevel")
@RestController
public class HaClaimCaseLevelController {
    @Autowired
    private HaClaimCaseLevelService haClaimCaseLevelService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public BaseResult<String> saveHaClaimCaseLevel(HaClaimCaseLevelDO haClaimCaseLevelDO){
      return haClaimCaseLevelService.saveHaClaimCaseLevel(haClaimCaseLevelDO);
    }
}

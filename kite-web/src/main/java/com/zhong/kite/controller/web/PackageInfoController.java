package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.UserService;
import com.zhong.kite.PackageInfoService;
import com.zhong.kite.controller.VO.PackageInfoVO;
import com.zhong.kite.model.PackageInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/packageInfos")
@Controller
@Slf4j
public class PackageInfoController {
    @Autowired
    private PackageInfoService packageInfoService;

    @RequestMapping(value = "/getPackageInfos",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getPackageInfoList(@RequestBody PackageInfoVO packageInfoVO){
        PackageInfoDTO packageInfoDTO = new PackageInfoDTO();
        BeanUtils.copyProperties(packageInfoVO,packageInfoDTO);
        log.info("查询包裹结果集请求参数为"+JSON.toJSONString(packageInfoDTO));
        Map<String,Object> map = packageInfoService.getPackageInfoList(packageInfoDTO);
        log.info("查询包裹结果集返回结果为:"+ JSON.toJSONString(map));
        return map;
    }

    @ResponseBody
    @RequestMapping("/delPackageInfos.action")
    public int delPackageInfos(@RequestParam("ids")int[] ids){
        log.info("删除包裹请求参数为"+ids);
        int i=packageInfoService.delPackageInfos(ids);
        return i;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delPackageInfo.action")
    public int delPackageInfo(@RequestParam("id")int id){
        int i=packageInfoService.delPackageInfo(id);
        return i;
    }

    /**
     * 根据用户id查询包裹信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPackageInfoById.action")
    public PackageInfoDO queryPackageInfoById(@RequestParam("id")int id){
        log.info("查询包裹信息请求参数为"+id);
        PackageInfoDO packageInfoDO = packageInfoService.queryPackageInfoById(id);
        return packageInfoDO;
    }

    @ResponseBody
    @RequestMapping("/updatePackageInfo.action")
    public int updatePackageInfo(PackageInfoVO packageInfoVO){
        log.info("更新包裹信息请求参数为"+JSON.toJSONString(packageInfoVO));
        PackageInfoDTO packageInfoDTO = new PackageInfoDTO();
        BeanUtils.copyProperties(packageInfoVO,packageInfoDTO);
        int i=packageInfoService.updatePackageInfo(packageInfoDTO);
        return i;
    }

    @ResponseBody
    @RequestMapping("/addPackageInfo.action")
    public int addPackageInfo(PackageInfoVO packageInfoVO){
        log.info("添加包裹信息请求参数为"+JSON.toJSONString(packageInfoVO));
        PackageInfoDTO packageInfoDTO = new PackageInfoDTO();
        BeanUtils.copyProperties(packageInfoVO,packageInfoDTO);
        int i=packageInfoService.addPackageInfo(packageInfoDTO);
        return i;
    }

}

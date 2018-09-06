package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.CommodityService;
import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.controller.VO.CommodityVO;
import com.zhong.kite.model.CommodityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/commodity")
@Controller
@Slf4j
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/getCommodities",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getCommodityList(@RequestBody CommodityVO commodityVO){
        CommodityDTO commodityDTO = new CommodityDTO();
        BeanUtils.copyProperties(commodityVO,commodityDTO);
        log.info("查询商品结果集请请求参数为"+JSON.toJSONString(commodityDTO));
        Map<String,Object> map = commodityService.getCommodityList(commodityDTO);
        log.info("查询商品结果集请返回结果为:"+ JSON.toJSONString(map));
        return map;
    }

    @ResponseBody
    @RequestMapping("/delCommodities.action")
    public int delCommoditys(@RequestParam("ids")int[] ids){
        log.info("删除商品请求参数为"+ids);
        int i=commodityService.delCommoditys(ids);
        return i;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delCommodity.action")
    public int delCommodity(@RequestParam("uid")int id){
        int i=commodityService.delCommodity(id);
        return i;
    }

    /**
     * 根据用户id查询商品信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCommodityById.action")
    public CommodityDO queryCommodityById(@RequestParam("id")int id){
        log.info("查询商品信息请求参数为"+id);
        CommodityDO commodity = commodityService.queryCommodityById(id);
        return commodity;
    }
    
    @ResponseBody
    @RequestMapping("/updateCommodity.action")
    public int updateCommodity(CommodityVO commodityVO){
        log.info("更新商品信息请求参数为"+JSON.toJSONString(commodityVO));
        CommodityDTO commodityDTO = new CommodityDTO();
        BeanUtils.copyProperties(commodityVO,commodityDTO);
        int i=commodityService.updateCommodity(commodityDTO);
        return i;
    }

    @ResponseBody
    @RequestMapping("/addCommodity.action")
    public int addCommodity(CommodityVO commodityVO){
        log.info("更新商品信息请求参数为"+JSON.toJSONString(commodityVO));
        CommodityDTO commodityDTO = new CommodityDTO();
        BeanUtils.copyProperties(commodityVO,commodityDTO);
        int i=commodityService.addCommodity(commodityDTO);
        return i;
    }
}

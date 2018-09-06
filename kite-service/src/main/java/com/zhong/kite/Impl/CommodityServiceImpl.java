package com.zhong.kite.Impl;

import com.zhong.kite.CommodityService;
import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.model.CommodityDTO;
import com.zhong.kite.repo.CommodityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityRepo commodityRepo;

    public Map<String,Object> getCommodityList(CommodityDTO commodity){
        Map<String,Object>map=new HashMap<String, Object>();
        int count = commodityRepo.getCommodityCount(commodity);
        int offset = (commodity.getPageNo() - 1) * commodity.getPageSize();
        commodity.setOffset(offset);
        List<CommodityDO> ulist=commodityRepo.getCommodityList(commodity);
        map.put("total", count);
        map.put("rows", ulist);
        return map;
    }


    @Override
    public int delCommoditys(int[] ids) {
        int sum=0;
        int y=0;
        for(int i=0;i<ids.length;i++){
            int x=commodityRepo.delCommodity(ids[i]);
            sum+=x;
        }
        if(sum==ids.length){
            y=1;
        }
        return y;
    }

    @Override
    public int addCommodity(CommodityDTO commodity) {
        return commodityRepo.addCommodity(commodity);
    }

    @Override
    public int updateCommodity(CommodityDTO commodity) {
        return commodityRepo.updateCommodity(commodity);
    }

    @Override
    public int delCommodity(int id) {
        int i=0;
        i=commodityRepo.delCommodity(id);
        return i;
    }

    @Override
    public CommodityDO queryCommodityById(int id) {
        return commodityRepo.queryCommodityById(id);
    }
}

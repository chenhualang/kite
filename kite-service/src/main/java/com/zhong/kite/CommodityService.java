package com.zhong.kite;

import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.model.CommodityDTO;

import java.util.Map;

public interface CommodityService {
    public Map<String,Object> getCommodityList(CommodityDTO commodity);

    public int delCommoditys(int[] ids) ;

    public int addCommodity(CommodityDTO commodity) ;

    public int updateCommodity(CommodityDTO commodity);

    public int delCommodity(int id);

    CommodityDO queryCommodityById(int id);
}

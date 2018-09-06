package com.zhong.kite.repo;

import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.mapper.CommodityDAO;
import com.zhong.kite.model.CommodityDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityRepo {
    @Resource
    private CommodityDAO commodityDAO;

    public int getCommodityCount(CommodityDTO commodityDTO) {
        return commodityDAO.getCommodityCount(commodityDTO);
    }

    public List<CommodityDO> getCommodityList(CommodityDTO commodityDTO){
        return commodityDAO.getCommodityList(commodityDTO);
    }

    public int delCommodity(int id) {
        return commodityDAO.delCommodity(id);
    }

    public int addCommodity(CommodityDTO commodity){
        return commodityDAO.addCommodity(commodity);
    }

    public int updateCommodity(CommodityDTO commodityDTO) {
        return commodityDAO.updateCommodity(commodityDTO);
    }

    public CommodityDO queryCommodityById(int id) {
        return commodityDAO.queryCommodityById(id);
    }
}

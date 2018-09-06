package com.zhong.kite.mapper;

import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.model.CommodityDTO;
import com.zhong.kite.model.UserDTO;

import java.util.List;

public interface CommodityDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityDTO record);

    int insertSelective(CommodityDTO record);

    CommodityDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommodityDTO record);

    int updateByPrimaryKey(CommodityDTO record);


    int getCommodityCount(CommodityDTO record);

    List<CommodityDO> getCommodityList(CommodityDTO record);

    int delCommodity(int id);

    int addCommodity(CommodityDTO commodity);

    int updateCommodity(CommodityDTO commodity);

    CommodityDO queryCommodityById(int id);
}
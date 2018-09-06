package com.zhong.kite.mapper;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.WarehouseDTO;

import java.util.List;

public interface WarehouseDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseDTO record);

    int insertSelective(WarehouseDTO record);

    WarehouseDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseDTO record);

    int updateByPrimaryKey(WarehouseDTO record);


    int getWarehouseCount(WarehouseDTO record);

    List<WarehouseDO> getWarehouseList(WarehouseDTO record);

    int delWarehouse(int id);

    int addWarehouse(WarehouseDTO warehouse);

    int updateWarehouse(WarehouseDTO userDO);

    WarehouseDO queryWarehouseById(int id);
}
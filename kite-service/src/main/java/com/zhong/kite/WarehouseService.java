package com.zhong.kite;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.WarehouseDTO;

import java.util.Map;

public interface WarehouseService {
    public Map<String,Object> getWarehouseList(WarehouseDTO warehouse);

    public int delWarehouses(int[] ids) ;

    public int addWarehouse(WarehouseDTO warehouse) ;

    public int updateWarehouse(WarehouseDTO warehouse);

    public int delWarehouse(int id);

    WarehouseDO queryWarehouseById(int id);
}

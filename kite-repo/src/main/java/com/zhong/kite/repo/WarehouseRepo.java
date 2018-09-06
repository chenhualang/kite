package com.zhong.kite.repo;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.mapper.UserDAO;
import com.zhong.kite.mapper.WarehouseDAO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.WarehouseDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class WarehouseRepo {
    @Resource
    private WarehouseDAO warehouseDAO;

    public int getWarehouseCount(WarehouseDTO warehouseDTO) {
        return warehouseDAO.getWarehouseCount(warehouseDTO);
    }

    public List<WarehouseDO> getWarehouseList(WarehouseDTO warehouseDTO){
        return warehouseDAO.getWarehouseList(warehouseDTO);
    }

    public int delWarehouse(int id) {
        return warehouseDAO.delWarehouse(id);
    }

    public int addWarehouse(WarehouseDTO warehouse){
        return warehouseDAO.addWarehouse(warehouse);
    }

    public int updateWarehouse(WarehouseDTO warehouseDTO) {
        return warehouseDAO.updateWarehouse(warehouseDTO);
    }

    public WarehouseDO queryWarehouseById(int id) {
        return warehouseDAO.queryWarehouseById(id);
    }
}

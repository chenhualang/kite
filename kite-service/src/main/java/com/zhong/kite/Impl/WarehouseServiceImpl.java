package com.zhong.kite.Impl;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.WarehouseService;
import com.zhong.kite.mapper.WarehouseDAO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.WarehouseDTO;
import com.zhong.kite.repo.UserRepo;
import com.zhong.kite.repo.WarehouseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Resource
    private WarehouseRepo warehouseRepo;

    public Map<String,Object> getWarehouseList(WarehouseDTO warehouse){
        Map<String,Object>map=new HashMap<String, Object>();
        int count = warehouseRepo.getWarehouseCount(warehouse);
        int offset = (warehouse.getPageNo() - 1) * warehouse.getPageSize();
        warehouse.setOffset(offset);
        List<WarehouseDO> ulist=warehouseRepo.getWarehouseList(warehouse);
        map.put("total", count);
        map.put("rows", ulist);
        return map;
    }


    @Override
    public int delWarehouses(int[] ids) {
        int sum=0;
        int y=0;
        for(int i=0;i<ids.length;i++){
            int x=warehouseRepo.delWarehouse(ids[i]);
            sum+=x;
        }
        if(sum==ids.length){
            y=1;
        }
        return y;
    }

    @Override
    public int addWarehouse(WarehouseDTO warehouse) {
        return warehouseRepo.addWarehouse(warehouse);
    }

    @Override
    public int updateWarehouse(WarehouseDTO warehouse) {
        return warehouseRepo.updateWarehouse(warehouse);
    }

    @Override
    public int delWarehouse(int id) {
        int i=0;
        i=warehouseRepo.delWarehouse(id);
        return i;
    }

    @Override
    public WarehouseDO queryWarehouseById(int id) {
        return warehouseRepo.queryWarehouseById(id);
    }
}

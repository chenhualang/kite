package com.zhong.kite.service.warehouse;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.WarehouseService;
import com.zhong.kite.model.WarehouseDTO;
import com.zhong.kite.service.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Map;

public class WarehouseServiceTest extends BaseTest {
    @Resource
    WarehouseService warehouseService;

    @Test
    public void testAdd(){
        WarehouseDTO warehouse = new WarehouseDTO();
        warehouse.setFullName("APT6352001");
        warehouse.setCountry("China");
        warehouse.setProvince("shanghai");
        warehouse.setCity("pudong");
        warehouse.setPhoneNumber("15021662091");
        int i = warehouseService.addWarehouse(warehouse);
        System.out.println("增加转运仓记录成功，结果为"+i);
    }

    @Test
    public void testDelete(){
        int i = warehouseService.delWarehouse(1);
        System.out.println("删除操作成功,结果为:"+i);
    }

    @Test
    public void testUpdate(){
        WarehouseDTO warehouse = new WarehouseDTO();
        warehouse.setId(2);
        warehouse.setFullName("APT6352005");
        warehouse.setCountry("China");
        warehouse.setProvince("hubei");
        int i = warehouseService.updateWarehouse(warehouse);
        System.out.println("更新转运仓成功，结果为"+i);
    }

    @Test
    public void testGetWarehouseList(){
        WarehouseDTO warehouse = new WarehouseDTO();
        warehouse.setPageNo(1);
        warehouse.setPageSize(10);
        Map<String, Object> warehouseList = warehouseService.getWarehouseList(warehouse);
        System.out.println("查询返回的结果为"+warehouseList);
    }

    @Test
    public void testQueryById(){
        WarehouseDO warehouse = warehouseService.queryWarehouseById(2);
        System.out.println("查询出来的结果为"+JSON.toJSONString(warehouse));
    }

}

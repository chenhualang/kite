package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.WarehouseService;
import com.zhong.kite.controller.VO.WarehouseVO;
import com.zhong.kite.model.WarehouseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/warehouses")
@Controller
@Slf4j
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping(value = "/getWarehouses",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getWarehouseList(@RequestBody WarehouseVO warehouseVO){
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        BeanUtils.copyProperties(warehouseVO,warehouseDTO);
        log.info("查询转运仓结果集请求参数为"+JSON.toJSONString(warehouseDTO));
        Map<String,Object> map = warehouseService.getWarehouseList(warehouseDTO);
        log.info("查询转运仓结果集返回结果为:"+ JSON.toJSONString(map));
        return map;
    }

    @ResponseBody
    @RequestMapping("/delWarehouses.action")
    public int delWarehouses(@RequestParam("ids")int[] ids){
        log.info("删除转运仓请求参数为"+ids);
        int i=warehouseService.delWarehouses(ids);
        return i;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delWarehouse.action")
    public int delWarehouse(@RequestParam("uid")int id){
        int i=warehouseService.delWarehouse(id);
        return i;
    }

    /**
     * 根据用户id查询仓库信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getWarehouseById.action")
    public WarehouseDO queryWarehouseById(@RequestParam("id")int id){
        log.info("查询仓库信息请求参数为"+id);
        WarehouseDO warehouse = warehouseService.queryWarehouseById(id);
        return warehouse;
    }
    
    @ResponseBody
    @RequestMapping("/updateWarehouse.action")
    public int updateWarehouse(WarehouseVO warehouseVO){
        log.info("更新转运仓信息请求参数为"+JSON.toJSONString(warehouseVO));
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        BeanUtils.copyProperties(warehouseVO,warehouseDTO);
        int i=warehouseService.updateWarehouse(warehouseDTO);
        return i;
    }

    @ResponseBody
    @RequestMapping("/addWarehouse.action")
    public int addWarehouse(WarehouseVO warehouseVO){
        log.info("添加转运仓信息请求参数为"+JSON.toJSONString(warehouseVO));
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        BeanUtils.copyProperties(warehouseVO,warehouseDTO);
        int i=warehouseService.addWarehouse(warehouseDTO);
        return i;
    }
}

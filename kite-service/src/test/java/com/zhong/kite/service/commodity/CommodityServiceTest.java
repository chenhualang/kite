package com.zhong.kite.service.commodity;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.CommodityService;
import com.zhong.kite.DO.CommodityDO;
import com.zhong.kite.model.CommodityDTO;
import com.zhong.kite.service.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

public class CommodityServiceTest extends BaseTest {
    @Resource
    CommodityService commodityService;

    @Test
    public void testAdd(){
        CommodityDTO commodity = new CommodityDTO();
        commodity.setBrand("nike");
        commodity.setKind("shoes");
        commodity.setName("nike air");
        commodity.setCount(1);
        commodity.setUnitPrice(new BigDecimal(1200.00));
        commodity.setTotalPrice(new BigDecimal(1200.00));
        commodity.setSize(43.00);
        int i = commodityService.addCommodity(commodity);
        System.out.println("增加转运仓记录成功，结果为"+i);
    }

    @Test
    public void testDelete(){
        int i = commodityService.delCommodity(1);
        System.out.println("删除操作成功,结果为:"+i);
    }

    @Test
    public void testUpdate(){
        CommodityDTO commodity = new CommodityDTO();
        commodity.setId(2);
        commodity.setBrand("adidas");
        commodity.setKind("shoes");
        commodity.setName("sanyecao");
        commodity.setCount(1);
        commodity.setUnitPrice(new BigDecimal(900.00));
        commodity.setTotalPrice(new BigDecimal(900.00));
        commodity.setSize(43.00);
        int i = commodityService.updateCommodity(commodity);
        System.out.println("更新转运仓成功，结果为"+i);
    }

    @Test
    public void testGetCommodityList(){
        CommodityDTO commodity = new CommodityDTO();
        commodity.setPageNo(1);
        commodity.setPageSize(10);
        Map<String, Object> commodityList = commodityService.getCommodityList(commodity);
        System.out.println("查询返回的结果为"+commodityList);
    }

    @Test
    public void testQueryById(){
        CommodityDO commodity = commodityService.queryCommodityById(2);
        System.out.println("查询出来的结果为"+JSON.toJSONString(commodity));
    }
}

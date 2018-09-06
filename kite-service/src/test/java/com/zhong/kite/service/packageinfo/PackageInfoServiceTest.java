package com.zhong.kite.service.packageinfo;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.PackageInfoService;
import com.zhong.kite.PackageInfoService;
import com.zhong.kite.model.PackageInfoDTO;
import com.zhong.kite.service.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Map;

public class PackageInfoServiceTest extends BaseTest {
    @Resource
    PackageInfoService packageInfoService;


    @Test
    public void testAdd(){
        PackageInfoDTO packageInfo = new PackageInfoDTO();
        packageInfo.setWarehouseNo("APT2563984");
        packageInfo.setDestinationRegion("China");
        packageInfo.setMerchantLogisticsNo("USA526321");
        packageInfo.setOrderNo("321235562");
        packageInfo.setStatus("未入库");
        packageInfo.setProvince("shanghai");
        packageInfo.setCity("pudong");
        packageInfo.setAddress("chenhui road No1001");
        int i = packageInfoService.addPackageInfo(packageInfo);
        System.out.println("增加转运仓记录成功，结果为"+i);
    }

    @Test
    public void testDelete(){
        int i = packageInfoService.delPackageInfo(1);
        System.out.println("删除操作成功,结果为:"+i);
    }

    @Test
    public void testUpdate(){
        PackageInfoDTO packageInfo = new PackageInfoDTO();
        packageInfo.setId(2);
        packageInfo.setWarehouseNo("APT2563666");
        packageInfo.setDestinationRegion("China");
        packageInfo.setMerchantLogisticsNo("USA526888");
        packageInfo.setOrderNo("321235562");
        packageInfo.setStatus("已入库");
        int i = packageInfoService.updatePackageInfo(packageInfo);
        System.out.println("更新转运仓成功，结果为"+i);
    }

    @Test
    public void testGetPackageInfoList(){
        PackageInfoDTO packageInfo = new PackageInfoDTO();
        packageInfo.setPageNo(1);
        packageInfo.setPageSize(10);
//        packageInfo.setMerchantLogisticsNo("USA526888");
        packageInfo.setOrderNo("");
        Map<String, Object> packageInfoList = packageInfoService.getPackageInfoList(packageInfo);
        System.out.println("查询返回的结果为"+packageInfoList);
    }

    @Test
    public void testQueryById(){
        PackageInfoDO packageInfoDO = packageInfoService.queryPackageInfoById(2);
        System.out.println("查询出来的结果为"+JSON.toJSONString(packageInfoDO));
    }
}

package com.zhong.kite.mapper;

import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.DO.WarehouseDO;
import com.zhong.kite.model.PackageInfoDTO;
import com.zhong.kite.model.WarehouseDTO;

import java.util.List;

public interface PackageInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(PackageInfoDTO record);

    int insertSelective(PackageInfoDTO record);

    PackageInfoDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PackageInfoDTO record);

    int updateByPrimaryKey(PackageInfoDTO record);


    int getPackageInfoCount(PackageInfoDTO record);

    List<PackageInfoDO> getPackageInfoList(PackageInfoDTO record);

    int delPackageInfo(int id);

    int addPackageInfo(PackageInfoDTO packageInfo);

    int updatePackageInfo(PackageInfoDTO packageInfoDO);

    PackageInfoDO queryPackageInfoById(int id);
}
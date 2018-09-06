package com.zhong.kite;

import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.model.PackageInfoDTO;

import java.util.Map;

public interface PackageInfoService {
    public Map<String,Object> getPackageInfoList(PackageInfoDTO packageInfo);

    public int delPackageInfos(int[] ids) ;

    public int addPackageInfo(PackageInfoDTO packageInfo) ;

    public int updatePackageInfo(PackageInfoDTO packageInfo);

    public int delPackageInfo(int id);

    PackageInfoDO queryPackageInfoById(int id);
}

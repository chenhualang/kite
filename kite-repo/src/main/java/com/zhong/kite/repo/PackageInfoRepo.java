package com.zhong.kite.repo;

import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.mapper.PackageInfoDAO;
import com.zhong.kite.mapper.PackageInfoDAO;
import com.zhong.kite.model.PackageInfoDTO;
import com.zhong.kite.model.PackageInfoDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PackageInfoRepo {
    @Resource
    private PackageInfoDAO packageInfoDAO;


    public int getPackageInfoCount(PackageInfoDTO packageInfoDTO) {
        return packageInfoDAO.getPackageInfoCount(packageInfoDTO);
    }

    public List<PackageInfoDO> getPackageInfoList(PackageInfoDTO packageInfoDTO){
        return packageInfoDAO.getPackageInfoList(packageInfoDTO);
    }

    public int delPackageInfo(int id) {
        return packageInfoDAO.delPackageInfo(id);
    }

    public int addPackageInfo(PackageInfoDTO packageInfo){
        return packageInfoDAO.addPackageInfo(packageInfo);
    }

    public int updatePackageInfo(PackageInfoDTO packageInfoDTO) {
        return packageInfoDAO.updatePackageInfo(packageInfoDTO);
    }

    public PackageInfoDO queryPackageInfoById(int id) {
        return packageInfoDAO.queryPackageInfoById(id);
    }
}

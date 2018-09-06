package com.zhong.kite.Impl;

import com.zhong.kite.DO.PackageInfoDO;
import com.zhong.kite.PackageInfoService;
import com.zhong.kite.model.PackageInfoDTO;
import com.zhong.kite.repo.PackageInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PackageInfoServiceImpl implements PackageInfoService {
    @Resource
    private PackageInfoRepo packageInfoRepo;

    public Map<String,Object> getPackageInfoList(PackageInfoDTO packageInfo){
        Map<String,Object>map=new HashMap<String, Object>();
        int count = packageInfoRepo.getPackageInfoCount(packageInfo);
        int offset = (packageInfo.getPageNo() - 1) * packageInfo.getPageSize();
        packageInfo.setOffset(offset);
        List<PackageInfoDO> ulist=packageInfoRepo.getPackageInfoList(packageInfo);
        map.put("total", count);
        map.put("rows", ulist);
        return map;
    }


    @Override
    public int delPackageInfos(int[] ids) {
        int sum=0;
        int y=0;
        for(int i=0;i<ids.length;i++){
            int x=packageInfoRepo.delPackageInfo(ids[i]);
            sum+=x;
        }
        if(sum==ids.length){
            y=1;
        }
        return y;
    }

    @Override
    public int addPackageInfo(PackageInfoDTO packageInfo) {
        return packageInfoRepo.addPackageInfo(packageInfo);
    }

    @Override
    public int updatePackageInfo(PackageInfoDTO packageInfo) {
        return packageInfoRepo.updatePackageInfo(packageInfo);
    }



    @Override
    public int delPackageInfo(int id) {
        int i=0;
        i=packageInfoRepo.delPackageInfo(id);
        return i;
    }

    @Override
    public PackageInfoDO queryPackageInfoById(int id) {
        return packageInfoRepo.queryPackageInfoById(id);
    }
}

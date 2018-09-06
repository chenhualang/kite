package com.zhong.kite.controller.VO;

import lombok.Data;

@Data
public class PackageInfoVO {
    private Integer id;

    private String warehouseNo;

    private String destinationRegion;

    private String merchantLogisticsNo;

    private String address;

    private String orderNo;

    private String userName;

    private String province;

    private String city;

    private String status;

    private int pageNo;

    private int pageSize;
}
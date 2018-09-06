package com.zhong.kite.controller.VO;

import lombok.Data;

@Data
public class WarehouseVO {
    private Integer id;

    private String fullName;

    private String addressLine;

    private String city;

    private String province;

    private String country;

    private Integer zip;

    private String phoneNumber;

    private int pageNo;

    private int pageSize;
}

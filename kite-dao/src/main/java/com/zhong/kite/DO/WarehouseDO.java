package com.zhong.kite.DO;

import lombok.Data;

@Data
public class WarehouseDO {
    private Integer id;

    private String fullName;

    private String addressLine;

    private String city;

    private String province;

    private String country;

    private Integer zip;

    private String phoneNumber;
}

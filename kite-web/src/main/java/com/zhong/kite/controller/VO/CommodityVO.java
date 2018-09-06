package com.zhong.kite.controller.VO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommodityVO {
    private Integer id;

    private String kind;

    private String brand;

    private String name;

    private Integer count;

    private String merchantLogisticsNo;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private Double size;

    private int pageNo;

    private int pageSize;
}
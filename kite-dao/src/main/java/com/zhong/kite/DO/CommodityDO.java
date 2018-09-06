package com.zhong.kite.DO;

import java.math.BigDecimal;

public class CommodityDO {
    private Integer id;

    private String kind;

    private String brand;

    private String name;

    private Integer count;

    private String merchantLogisticsNo;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private Double size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMerchantLogisticsNo() {
        return merchantLogisticsNo;
    }

    public void setMerchantLogisticsNo(String merchantLogisticsNo) {
        this.merchantLogisticsNo = merchantLogisticsNo;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
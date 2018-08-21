package com.zhong.kite.DO;

import lombok.Data;

import java.util.Date;
@Data
public class UserDO {
    private Integer userId;

    private String userCode;

    private String userName;

    private Date createTime;

    private Date modifiedTime;

}
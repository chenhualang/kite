package com.zhong.kite.controller.VO;

import lombok.Data;

@Data
public class AccountInfoVO {
    private Integer id;

    private String nickname;

    private String apt;

    private Integer couponCount;

    private String mailAddress;

    private String cellphone;

    private String password;

    private String againPasswd;
}
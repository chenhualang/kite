/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.zhong.kite.model.enums;

import java.text.MessageFormat;

/**
 * 类ErrorCode.java的实现描述：错误代码 异常编码规则：异常编码共5位<br>
 * 0:业务处理成功<br>
 * 20001-20009:通用错误<br>
 * 
 * @author liujianli 2016年11月19日 上午9:00:30
 */
public enum ErrorCodeEnum {

    CMN_20001("20001", "参数不合法"),
    SYS_RUNTIME_ERROR("0", "业务处理成功");

    private String code;
    private String pattern;

    private ErrorCodeEnum(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMsg(Object... params) {
        String errorMsg = "";
        if ((params == null) || (params.length == 0)) {
            errorMsg = pattern;
        } else {
            MessageFormat msgFmt = new MessageFormat(pattern);
            errorMsg = msgFmt.format(params);
        }
        return errorMsg;
    }

    public String getErrorMsg() {
        return pattern;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}

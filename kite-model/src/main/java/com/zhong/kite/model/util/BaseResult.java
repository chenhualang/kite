package com.zhong.kite.model.util;

import java.io.Serializable;

public class BaseResult<T> implements Serializable{
        private static final long serialVersionUID = 5758020086424746744L;
        public static final String SUCCESS_CODE = "0";
        private String code;
        private String message;
        private T result;

        public BaseResult() {
            setCodeSuccess();
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setCodeSuccess() {
            this.code = "0";
        }

        public boolean success() {
            return "0".equals(this.code);
        }

        public boolean failed() {
            return !this.success();
        }

        public T getResult() {
            return this.result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        public void setSuccess(T result) {
            this.setCodeSuccess();
            this.result = result;
        }

        public String toString() {
            return "BaseResult [code=" + this.code + ", message=" + this.message + ", result=" + this.result + "]";
        }
}

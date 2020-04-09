package com.huiyalin.exception;

/**
 * 自定义异常
 */
public class SysException extends Exception {
    //存储提示信息的
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}

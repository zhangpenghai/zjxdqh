package com.zjxdqh.face.exception;

/**
 * 业务异常类
 *
 * @author Yorking
 * @date 2019/05/07
 */
public class BuzzException extends RuntimeException {

    private ExceptionEnum code;

    public BuzzException(String msg) {
        super(msg);
    }

    public BuzzException(ExceptionEnum code) {
        super(BuzzException.class.getCanonicalName()+":"+code.getCode()+":"+code.getMsg());
        this.code = code;
    }

    public ExceptionEnum getCode() {
        return code;
    }
}

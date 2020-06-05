//package com.zjxdqh.happchargeserver.config;
//
//import com.zjxdqh.face.exception.BuzzException;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @author Yorking
// * @date 2019/08/13
// */
//@ControllerAdvice
//@Log4j2
//public class GlobalExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(value = BuzzException.class)//BusinessException是自定义的一个异常
//    public ResponseDto businessExceptionHandler(BuzzException ex) {
//        log.error("捕获到 BusinessException 异常: code=" + ex.getCode() + " , errorMessage=" + ex.getErrorMessage());
//        return new (ex.getCode(), ex.getErrorMessage());
//    }
//}

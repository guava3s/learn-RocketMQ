package com.guava3s.expection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Micolen
 * @version 1.0
 * @ClassName GlobalExceptionHandler
 * @date 2022/6/23 14:01
 * @mail 2168626265@qq.com
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public String handle(Exception e) {
        log.error("出现异常，异常信息为：{}", e.getMessage());
        return "出现异常，异常信息为：" + e.getMessage();
    }
}

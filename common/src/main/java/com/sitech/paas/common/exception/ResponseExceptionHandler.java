package com.sitech.paas.common.exception;

import com.sitech.paas.common.result.ResponseResult;
import com.sitech.paas.common.result.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author huangzb
 * @date 2022/4/22
 */
@Slf4j
@RestControllerAdvice
public class ResponseExceptionHandler {

    /**
     * 默认全局异常处理。
     * 指定客户端收到的http状态码为500
     *
     * @param e 异常对象
     * @return ResponseResult响应结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResponseResult.fail(ReturnCode.result500.getCode(), e.getMessage());
    }
}

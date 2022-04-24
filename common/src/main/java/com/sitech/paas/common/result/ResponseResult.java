package com.sitech.paas.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础返回类，返回码遵循阿里错误列表
 *
 * @author huangzb
 * @date 2022/4/22
 */
@Data
public class ResponseResult<T> {
    @ApiModelProperty(value = "返回码", example = "00000")
    private Integer code;
    @ApiModelProperty(value = "返回码描述", example = "ok")
    private String msg;
    @ApiModelProperty(value = "返回结果")
    private T data;
    @ApiModelProperty(value = "响应时间", example = "1625736481648")
    private long timestamp;

    public ResponseResult() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> resultData = new ResponseResult<>();
        resultData.setCode(ReturnCode.result200.getCode());
        resultData.setMsg(ReturnCode.result200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResponseResult<T> fail(int code, String message) {
        ResponseResult<T> resultData = new ResponseResult<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        return resultData;
    }


    /**
     * 异常返回结果中加上堆栈信息打印
     *
     * @param code               返回码
     * @param message            返回错误信息
     * @param stackTraceElements 堆栈内容
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> fail(int code, String message, T stackTraceElements) {
        ResponseResult<T> resultData = new ResponseResult<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        resultData.setData(stackTraceElements);
        return resultData;
    }
}

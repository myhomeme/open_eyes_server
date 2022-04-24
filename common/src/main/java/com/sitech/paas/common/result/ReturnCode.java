package com.sitech.paas.common.result;

/**
 * 返回码说明枚举
 * @author huangzb
 * @date 2022/4/22
 */
public enum ReturnCode {
    /**操作成功**/
    result200(200,"操作成功"),
    /**操作失败**/
    result999(999,"操作失败"),
    /**服务限流**/
    result201(201,"服务加载中,请稍后再试!"),
    /**access_denied**/
    result403(403,"无访问权限,请联系管理员授予权限"),
    /**access_denied**/
    result401(401,"匿名用户访问无权限资源时的异常"),
    /**服务异常**/
    result500(500,"系统异常，请稍后重试"),

    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");



    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

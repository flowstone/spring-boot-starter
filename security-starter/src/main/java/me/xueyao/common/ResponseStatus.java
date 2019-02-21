package me.xueyao.common;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:55
 */
public enum  ResponseStatus {
    SUCCESS(10000, "成功"),
    INVALID_SIGNATURE(20002, "无效签名"),
    BAD_REQUEST(40000,"请求有误"),
    BAD_PARAM(40001, "参数错误"),
    UNAUTHORIZED(40401, "用户未身份认证"),
    NO_PERMISSION(40403, "没有接口权限"),
    NOT_FOUND(40404,"您所访问的资源不存在"),
    Method_NOT_ALLOWED(40405,"方法不被允许"),
    EXCEPTION(50000, "业务处理失败，请稍后再试");

    Integer code;
    String message;

    public Integer getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

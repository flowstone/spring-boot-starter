package me.xueyao.common;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/22 17:33
 */
public enum ResponseStatus {
    SUCCESS(20002, "成功"),
    BADPARAM(10001, "参数错误"),
    EXCEPTION(40000, "业务处理失败");

    int code;
    String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

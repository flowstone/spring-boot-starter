package me.xueyao.common;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:31
 */
public class BaseResponse {
    private Integer code;
    private String msg;
    private Object date;

    public BaseResponse() {
    }

    public BaseResponse(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.msg = responseStatus.getMsg();
    }
    public BaseResponse(ResponseStatus responseStatus, String msg) {
        this.code = responseStatus.getCode();
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}

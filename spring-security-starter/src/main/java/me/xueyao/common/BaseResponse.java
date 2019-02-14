package me.xueyao.common;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:54
 */
public class BaseResponse {
    private Integer code;
    private String message;
    private Object data;

    public BaseResponse() {

    }

    public BaseResponse(ResponseStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseResponse(ResponseStatus status, String message) {
        this.code = status.getCode();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

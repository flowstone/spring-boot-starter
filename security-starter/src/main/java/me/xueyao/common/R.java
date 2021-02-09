package me.xueyao.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:54
 */
@Getter
@NoArgsConstructor
public class R {
    private  Integer code;
    private  String message;
    private  Object data;


    public R(String msg) {
        this.message = msg;
    }
    public static R ofSuccess(String msg) {
        return new R(msg);
    }



}

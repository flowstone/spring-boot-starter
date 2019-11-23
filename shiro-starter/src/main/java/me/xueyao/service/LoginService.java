package me.xueyao.service;

import me.xueyao.common.BaseResponse;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/22 17:23
 */
public interface LoginService {

    BaseResponse login(String username, String password);

    BaseResponse logout();
}

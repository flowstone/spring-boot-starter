package me.xueyao.service;

import me.xueyao.common.BaseResponse;
import me.xueyao.entity.Role;
import me.xueyao.entity.User;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/22 17:23
 */
public interface LoginService {

    BaseResponse addUser(User user);

    BaseResponse addRole(Role role);

    BaseResponse getByName(String name);
}

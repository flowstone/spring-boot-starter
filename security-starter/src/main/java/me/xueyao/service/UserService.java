package me.xueyao.service;

import me.xueyao.common.BaseResponse;
import me.xueyao.model.entity.User;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:53
 */
public interface UserService {

    BaseResponse getUser(int id);

    BaseResponse addUser(User user);

    BaseResponse modifyUser(User user);

    BaseResponse removeUser(int id);
}

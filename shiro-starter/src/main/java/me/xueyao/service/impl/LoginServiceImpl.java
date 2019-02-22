package me.xueyao.service.impl;

import me.xueyao.common.BaseResponse;
import me.xueyao.entity.Role;
import me.xueyao.entity.User;
import me.xueyao.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:28
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Override
    public BaseResponse addUser(User user) {
        return null;
    }

    @Override
    public BaseResponse addRole(Role role) {
        return null;
    }

    @Override
    public BaseResponse getByName(String name) {
        return null;
    }
}

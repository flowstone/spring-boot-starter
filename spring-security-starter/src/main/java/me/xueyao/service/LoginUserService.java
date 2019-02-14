package me.xueyao.service;

import me.xueyao.model.entity.User;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-08 22:43
 **/
public interface LoginUserService {

    User loadUserByUsername(String username);
}

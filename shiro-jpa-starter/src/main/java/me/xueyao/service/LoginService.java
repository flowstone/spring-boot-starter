package me.xueyao.service;

import me.xueyao.entity.Role;
import me.xueyao.entity.User;

import java.util.Map;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/21 15:54
 */

public interface LoginService {

    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}

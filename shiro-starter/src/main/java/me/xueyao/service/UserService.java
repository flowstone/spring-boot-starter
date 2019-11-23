package me.xueyao.service;

import me.xueyao.vo.UserVo;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:19
 **/
public interface UserService {
    UserVo findUserByName(String username);
}

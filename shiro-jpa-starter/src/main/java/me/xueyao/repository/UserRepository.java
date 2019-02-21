package me.xueyao.repository;

import me.xueyao.entity.User;

/**
 * @author: Simon.Xue
 * @date: 2019/2/21 16:00
 */
public interface UserRepository extends BaseRepository<User, Long> {

    User findByName(String name);
}

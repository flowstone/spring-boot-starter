package me.xueyao.repository;

import me.xueyao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:17
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}

package me.xueyao.repository;

import me.xueyao.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:31
 **/
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUserId(Integer userId);
}

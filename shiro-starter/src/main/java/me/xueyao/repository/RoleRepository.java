package me.xueyao.repository;

import me.xueyao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-11-22 17:43
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

package me.xueyao.repository;

import me.xueyao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-11-22 18:07
 **/
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}

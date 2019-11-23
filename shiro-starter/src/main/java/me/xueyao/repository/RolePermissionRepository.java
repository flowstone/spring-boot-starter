package me.xueyao.repository;

import me.xueyao.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:42
 **/
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    List<RolePermission> findByRoleId(Integer roleId);
}

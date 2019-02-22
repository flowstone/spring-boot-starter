package me.xueyao.mapper;

import me.xueyao.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/22 17:30
 */
@Repository
public interface RoleMapper {
    int insert(Role role);
}

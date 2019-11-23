package me.xueyao.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import me.xueyao.entity.Permission;
import me.xueyao.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 17:05
 **/
@Data
@Accessors(chain = true)
public class RoleVo implements Serializable {
    Role role;

    List<Permission> permissionList;
}

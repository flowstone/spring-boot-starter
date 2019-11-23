package me.xueyao.vo;

import lombok.Data;
import me.xueyao.entity.Permission;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-23 10:46
 **/
@Data
public class RolePermissionVo {
    private Integer roleId;
    private String roleName;
    private List<Permission> permissionList;

}

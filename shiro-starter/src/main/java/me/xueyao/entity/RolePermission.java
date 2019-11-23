package me.xueyao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:20
 */
@Data
@Entity
public class RolePermission {
    @Id
    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "permission_id")
    private Integer permissionId;


}

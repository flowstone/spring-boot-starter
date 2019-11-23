package me.xueyao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:06
 */
@Data
@Entity
public class UserRole {
    @Id
    private Integer id;
    @Column(name = "user_id", columnDefinition = "INT NOT NULL COMMENT '用户id'")
    private Integer userId;
    @Column(name = "role_id", columnDefinition = "INT NOT NULL COMMENT '角色id'")
    private Integer roleId;

}

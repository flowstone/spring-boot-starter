package me.xueyao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:07
 */
@Data
@Entity
public class User {
    @Id
    private Integer id;
    @Column(name = "username", columnDefinition = "VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户名'")
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR(64) NOT NULL DEFAULT '' COMMENT '密码'")
    private String password;
    @Column(columnDefinition = "VARCHAR(32) COMMENT '昵称'")
    private String nickname;
    @Column(columnDefinition = "VARCHAR(64) COMMENT '盐'")
    private String salt;
    @Column(columnDefinition = "TINYINT DEFAULT 0 COMMENT '性别 0女 1男'")
    private Integer sex;
    @Column(columnDefinition = "VARCHAR(64) COMMENT '邮箱'")
    private String email;
    @Column(name = "is_deleted", columnDefinition = "TINYINT DEFAULT 0 COMMENT '是否删除 0未删除 1删除'")
    private Integer deleted;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDateTime createTime;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    private LocalDateTime updateTime;

    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}

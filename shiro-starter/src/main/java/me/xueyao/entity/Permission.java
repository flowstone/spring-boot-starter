package me.xueyao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:19
 */
@Data
@Entity
public class Permission {
    @Id
    private Integer id;
    @Column(name = "name", columnDefinition = "VARCHAR(32) NOT NULL DEFAULT '' COMMENT '权限名'")
    private String name;
    @Column(name = "is_deleted", columnDefinition = "TINYINT DEFAULT 0 COMMENT '是否删除 0未删除 1删除'")
    private Integer deleted;
    @Column(name = "create_time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDateTime createTime;
    @Column(name = "update_time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

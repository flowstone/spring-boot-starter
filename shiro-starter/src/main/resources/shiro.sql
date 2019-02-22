CREATE TABLE user(
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户名',
  password VARCHAR(64) NOT NULL DEFAULT '' COMMENT '密码',
  nickname VARCHAR(32) COMMENT '昵称',
  sex TINYINT DEFAULT 0 COMMENT '性别 0女 1男',
  email VARCHAR(64) COMMENT '邮箱',
  is_deleted TINYINT DEFAULT 0 COMMENT '是否删除 0未删除 1删除',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME  COMMENT '更新时间',
  PRIMARY KEY(id)
)CHARACTER SET UTF8 COMMENT '用户表';

CREATE TABLE role(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '角色名',
  is_deleted TINYINT DEFAULT 0 COMMENT '是否删除 0未删除 1删除',
  create_time DATETIME  COMMENT '创建时间',
  update_time DATETIME  COMMENT '更新时间',
  PRIMARY KEY(id)
)CHARACTER SET UTF8 COMMENT '角色表';

CREATE TABLE permission(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '权限名',
  is_deleted TINYINT DEFAULT 0 COMMENT '是否删除 0未删除 1删除',
  create_time DATETIME  COMMENT '创建时间',
  update_time DATETIME  COMMENT '更新时间',
  PRIMARY KEY(id)
)CHARACTER SET UTF8 COMMENT '权限表';

CREATE TABLE user_role(
  user_id INT NOT NULL COMMENT '用户id',
  role_id INT NOT NULL COMMENT '角色id'
) CHARACTER SET UTF8 COMMENT '用户角色表';

CREATE TABLE role_permission(
  role_id INT NOT NULL COMMENT '角色id',
  permission_id INT NOT NULL COMMENT '权限id'
) CHARACTER SET UTF8 COMMENT '角色权限表';
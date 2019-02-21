drop table user;
create table user(
  id int not null auto_increment,
  name varchar(32) not null comment '用户名',
  password varchar(64) not null comment '密码',
  primary key(id)
) character set utf8 comment '用户表';

create table role(
  id int not null auto_increment,
  role_name varchar(32) not null comment '角色名',
  user_id int not null comment '用户id',
  primary key(id)
)character set utf8 comment '角色表';

create table permission(
  id int not null auto_increment,
  permission varchar(32) not null comment '权限名',
  role_id int not null comment '角色id',
  primary key(id)
)character set utf8 comment '权限表';
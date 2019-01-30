package me.xueyao.model.httpRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:40
 */
@ApiModel(description = "用户信息请求对象")
public class UserRequest {
    private Integer id;
    @ApiModelProperty(value = "用户名", example = "小明")
    private String username;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
    @ApiModelProperty(value = "昵称", example = "石头")
    private String nickname;
    @ApiModelProperty(value = "性别", example = "1")
    private Integer sex;
    @ApiModelProperty(value = "邮箱", example = "xueyao.me@gmail.com")
    private String email;
    @ApiModelProperty(hidden = true)
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}

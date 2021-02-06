package me.xueyao.controller;

import me.xueyao.common.BaseResponse;
import me.xueyao.common.ResponseStatus;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Simon.Xue
 * @date 2019-11-23 13:00
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/userInfo")
    //@RequiresRoles("admin")
    @RequiresPermissions("Retrieve")
    public BaseResponse userInfo() {
        return new BaseResponse(ResponseStatus.SUCCESS, "访问用户信息成功");
    }


    @GetMapping("/userAdd")
    @RequiresPermissions("Create")
    public BaseResponse userInfoAdd() {
        return new BaseResponse(ResponseStatus.SUCCESS, "添加用户信息成功");
    }


    @GetMapping("/userDel")
    @RequiresPermissions("Delete")
    public BaseResponse userDel() {
        return new BaseResponse(ResponseStatus.SUCCESS, "删除用户信息成功");
    }
}

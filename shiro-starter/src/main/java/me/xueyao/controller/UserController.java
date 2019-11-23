package me.xueyao.controller;

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

    @GetMapping("/userList")
    @RequiresPermissions("user:view")
    public String userInfo() {
        return "userList";
    }


    @GetMapping("/userAdd")
    @RequiresPermissions("user:add")
    public String userInfoAdd() {
        return "userInfoAdd";
    }


    @GetMapping("/userDel")
    @RequiresPermissions("user:del")
    public String userDel() {
        return "userDel";
    }
}

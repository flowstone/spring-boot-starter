package me.xueyao.controller;

import me.xueyao.entity.Role;
import me.xueyao.entity.User;
import me.xueyao.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Simon.Xue
 * @date: 2019/2/21 16:51
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("username").toString(), map.get("password").toString());
        subject.login(token);
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/error")
    public String error() {
        return "error ok!";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Map<String, Object> map) {
        User user = loginService.addUser(map);
        return "addUser is ok! \n" + user;
    }

    @PostMapping("/addRole")
    public String addRole(@RequestBody Map<String, Object> map) {
        Role role = loginService.addRole(map);
        return "addRole is ok! \n" + role;
    }

    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @GetMapping("/create")
    public String create() {
        return "Create success!";
    }


}

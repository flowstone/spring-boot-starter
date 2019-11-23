package me.xueyao.controller;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.common.BaseResponse;
import me.xueyao.common.ResponseStatus;
import me.xueyao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Simon.Xue
 * @date 2019-11-23 12:53
 **/
@RestController
@Slf4j
public class HomeController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/403")
    public String unauthorizedRole() {
        log.info("没有权限");
        return null;
    }

    @GetMapping("/index")
    public String index() {
        log.info("首页");
        return null;
    }

    @GetMapping("/login")
    public String toLogin() {
        return "需要登陆";
    }
    @PostMapping("/toLogin")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password) {
        log.info("登陆");
        BaseResponse login = loginService.login(username, password);
        if (login.getCode().equals(ResponseStatus.SUCCESS)) {
            log.info("登陆成功");
        }
        return "登陆成功";
    }
}

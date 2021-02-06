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
    public BaseResponse unauthorizedRole() {
        log.info("没有权限");
        return new BaseResponse(ResponseStatus.EXCEPTION, "没有权限");
    }

    @GetMapping("/index")
    public BaseResponse index() {
        log.info("首页");
        return new BaseResponse(ResponseStatus.SUCCESS, "首页");
    }

    @GetMapping("/login")
    public BaseResponse toLogin() {
        log.info("需要登录");
        return new BaseResponse(ResponseStatus.SUCCESS, "需要登录");
    }
    @PostMapping("/toLogin")
    public BaseResponse login(@RequestParam("username")String username,
                        @RequestParam("password")String password) {
        log.info("登陆");
        BaseResponse login = loginService.login(username, password);
        if (login.getCode().equals(ResponseStatus.SUCCESS)) {
            log.info("登陆成功");
        }
        return new BaseResponse(ResponseStatus.SUCCESS, "登陆成功");
    }
}

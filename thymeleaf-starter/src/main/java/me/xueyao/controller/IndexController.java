package me.xueyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/14 16:44
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

package me.xueyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/14 16:06
 */
@Controller
@RequestMapping("/")
public class ShiroController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/403")
    public String error() {
        return "403";
    }
}

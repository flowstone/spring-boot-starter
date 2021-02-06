package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.service.UserService;
import me.xueyao.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShiroStarterApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        //UserVo admin = userService.findUserByName("admin");

        log.info("{}", MD5Utils.getPassword("123456"));
    }

    @Test
    public void test() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
            token.setRememberMe(true);
            currentUser.login(token);
        }
    }

}


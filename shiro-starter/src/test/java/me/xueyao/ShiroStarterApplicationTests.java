package me.xueyao;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.service.UserService;
import me.xueyao.vo.UserVo;
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
        UserVo admin = userService.findUserByName("admin");
        log.info("{}", JSONObject.toJSONString(admin));
    }

}


package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.common.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringSecurityStarterApplicationTests {

    @Test
    public R contextLoads() {
        //log.info("{}",);
        return R.ofSuccess("sjyq");
    }

}


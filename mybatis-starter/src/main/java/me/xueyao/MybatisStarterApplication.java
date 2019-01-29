package me.xueyao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.xueyao.mapper")
public class MybatisStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStarterApplication.class, args);
    }

}


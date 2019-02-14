package me.xueyao.config;

import me.xueyao.model.entity.User;
import me.xueyao.service.LoginUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-08 22:40
 **/
@Component
public class CustomerUserDetail implements LoginUserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public User loadUserByUsername(String username) {
        logger.info("用户名，username = {}", username);

        return null;
    }
}

package me.xueyao.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/2/14 11:39
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        //创建shiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //进行顺序拦截配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        //配置logout过滤器
        filterChainMap.put("/logout", "logout");
        //配置所有url必须通过认证才能访问
        filterChainMap.put("/**", "authc");
        //设置登陆url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置成功后跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //设置默认过滤链
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        return new DefaultWebSecurityManager();
    }
}

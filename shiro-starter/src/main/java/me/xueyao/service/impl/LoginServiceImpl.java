package me.xueyao.service.impl;

import me.xueyao.common.BaseResponse;
import me.xueyao.common.ResponseStatus;
import me.xueyao.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author: Simon.Xue
 * @date: 2019/2/22 17:28
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Override
    public BaseResponse login(String username, String password) {
        //判断用户存在，密码是否正确


        //1.获取subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        //将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //认证
        currentUser.login(token);
        Session session = currentUser.getSession();
        session.setAttribute("username", username);
        return new BaseResponse(ResponseStatus.SUCCESS, "验证成功");
    }

    @Override
    public BaseResponse logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new BaseResponse(ResponseStatus.SUCCESS, "退出成功");
    }
}

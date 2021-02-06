package me.xueyao.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.entity.User;
import me.xueyao.service.UserService;
import me.xueyao.vo.RolePermissionVo;
import me.xueyao.vo.UserVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:13
 **/
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        UserVo userVo = userService.findUserByName(user.getUsername());
        List<RolePermissionVo> rolePermissionVoList = userVo.getRolePermissionVoList();

        rolePermissionVoList.forEach(rolePermissionVo -> {
            simpleAuthorizationInfo.addRole(rolePermissionVo.getRoleName());
            rolePermissionVo.getPermissionList().forEach(permission -> {
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            });
        });
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("token = {}", JSONObject.toJSONString(token));

        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());

        UserVo userVo = userService.findUserByName(username);
        log.info("user = {}", JSONObject.toJSONString(userVo));
        if (null == userVo) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                ////这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
                userVo.getUser(),
                //密码
                userVo.getUser().getPassword(),
                //不需要盐了
                //ByteSource.Util.bytes(userVo.getUser().getSalt()),
                getName()
        );
        return authenticationInfo;
    }
}

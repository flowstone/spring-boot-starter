package me.xueyao.service.impl;

import me.xueyao.entity.Permission;
import me.xueyao.entity.Role;
import me.xueyao.entity.User;
import me.xueyao.repository.RoleRepository;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author: Simon.Xue
 * @date: 2019/2/21 15:56
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Role addRole(Map<String, Object> map) {
        Optional<User> user = userRepository.findById(Long.valueOf(map.get("userId").toString()));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user.get());

        Permission permission = new Permission();
        permission.setPermission("create");
        permission.setRole(role);

        Permission permission1 = new Permission();
        permission1.setPermission("update");
        permission1.setRole(role);

        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission);
        permissions.add(permission1);

        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}

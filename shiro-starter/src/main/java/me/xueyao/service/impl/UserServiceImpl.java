package me.xueyao.service.impl;

import me.xueyao.entity.*;
import me.xueyao.repository.*;
import me.xueyao.service.UserService;
import me.xueyao.vo.RolePermissionVo;
import me.xueyao.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:20
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserVo findUserByName(String username) {
        User user = userRepository.findByUsername(username);
        List<UserRole> userRoleList = userRoleRepository.findByUserId(user.getId());
        List<Role> roleList = roleRepository.findAll();
        List<RolePermission> rolePermissionList = rolePermissionRepository.findAll();
        List<Permission> permissionList = permissionRepository.findAll();
        UserVo userVo = new UserVo();
        userVo.setUser(user);

        List<Integer> roleIdList = new ArrayList<>();
        userRoleList.forEach(userRole -> {
            if (user.getId().equals(userRole.getUserId())) {
                roleIdList.add(userRole.getRoleId());
            }
        });

        List<RolePermissionVo> rolePermissionVoList = new ArrayList<>();
        roleIdList.forEach(roleId -> {
            RolePermissionVo rolePermissionVo = new RolePermissionVo();
            roleList.forEach(role -> {
                if (roleId.equals(role.getId())) {
                    rolePermissionVo.setRoleId(role.getId());
                    rolePermissionVo.setRoleName(role.getName());
                }
            });

            List<Integer> permissionIds = new ArrayList<>();
            rolePermissionList.forEach(rolePermission -> {
                if (roleId.equals(rolePermission.getRoleId())) {
                    permissionIds.add(rolePermission.getPermissionId());
                }
            });

            List<Permission> permissions = new ArrayList<>();
            permissionList.forEach(permission -> {
                permissionIds.forEach(integer -> {
                    if (permission.getId().equals(integer)) {
                        permissions.add(permission);
                    }
                });
            });
            rolePermissionVo.setPermissionList(permissionList);
            rolePermissionVoList.add(rolePermissionVo);
        });
        userVo.setRolePermissionVoList(rolePermissionVoList);

        return userVo;
    }
}

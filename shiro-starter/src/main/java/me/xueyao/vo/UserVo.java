package me.xueyao.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import me.xueyao.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-11-22 17:03
 **/
@Data
@Accessors(chain = true)
public class UserVo implements Serializable {

    User user;

    List<RolePermissionVo> rolePermissionVoList;

}

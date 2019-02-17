package me.xueyao.mapper;

import me.xueyao.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 16:51
 */
@Repository
public interface UserMapper {

    User selectUserById(@Param("id") int id);

    int updateUser(User user);

    int deleteUserById(@Param("id") int id);

    int insertUser(User user);

    User selectUserByUsername(@Param("username") String username);
}

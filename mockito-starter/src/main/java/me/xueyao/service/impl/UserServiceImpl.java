package me.xueyao.service.impl;

import me.xueyao.common.BaseResponse;
import me.xueyao.common.ResponseStatus;
import me.xueyao.mapper.UserMapper;
import me.xueyao.model.entity.User;
import me.xueyao.model.httpResponse.UserResponse;
import me.xueyao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 17:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseResponse getUser(int id) {
        logger.info("查询用户信息>>>>");
        BaseResponse baseResponse = new BaseResponse();
        User user = userMapper.selectUserById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        if (null == user) {
            logger.info("查询用户信息为空");
            baseResponse.setCode(ResponseStatus.SUCCESS.getCode());
            baseResponse.setMessage("查询用户信息为空");
            return baseResponse;
        }
        baseResponse.setCode(ResponseStatus.SUCCESS.getCode());
        baseResponse.setMessage("查询用户信息成功");
        baseResponse.setData(userResponse);
        logger.info("查询用户信息<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse addUser(User user) {
        logger.info("添加用户信息>>>>");
        BaseResponse baseResponse = new BaseResponse();
        User userExist = userMapper.selectUserByUsername(user.getUsername());
        if (null != userExist) {
            logger.warn("用户已存在，请勿重复添加");
            baseResponse.setCode(ResponseStatus.EXCEPTION.getCode());
            baseResponse.setMessage("用户已存在，请勿重复添加");
            return baseResponse;
        }

        int insertCount = userMapper.insertUser(user);
        if (1 > insertCount) {
            logger.warn("添加用户信息失败");
            baseResponse.setCode(ResponseStatus.BAD_PARAM.getCode());
            baseResponse.setMessage("添加用户信息失败");
            return baseResponse;
        }
        baseResponse.setCode(ResponseStatus.SUCCESS.getCode());
        baseResponse.setMessage("添加用户信息成功");
        logger.info("添加用户信息<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse modifyUser(User user) {
        logger.info("更新用户信息>>>>");
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.EXCEPTION);
        int updateCount = userMapper.updateUser(user);
        if (1 > updateCount) {
            logger.warn("更新用户信息失败");
            baseResponse.setMessage("更新用户信息失败");
            return baseResponse;
        }
        baseResponse.setCode(ResponseStatus.SUCCESS.getCode());
        baseResponse.setMessage("更新用户信息成功");
        logger.info("更新用户信息<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse removeUser(int id) {
        logger.info("删除用户信息>>>>");
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.EXCEPTION);
        User userExist = userMapper.selectUserById(id);
        if (null == userExist) {
            logger.warn("用户信息不存在");
            baseResponse.setMessage("用户信息不存在");
            return baseResponse;
        }
        int deleteCount = userMapper.deleteUserById(id);
        if (1 > deleteCount) {
            logger.warn("删除用户信息失败");
            baseResponse.setMessage("删除用户信息失败");
            return baseResponse;
        }
        baseResponse.setCode(ResponseStatus.SUCCESS.getCode());
        baseResponse.setMessage("删除用户信息成功");
        logger.info("删除用户信息<<<<");
        return baseResponse;
    }
}

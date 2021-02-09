package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.xueyao.common.BaseResponse;
import me.xueyao.common.ResponseStatus;
import me.xueyao.model.entity.User;
import me.xueyao.model.httpRequest.UserRequest;
import me.xueyao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/29 17:37
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户控制")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户信息")
    @GetMapping("/get/{userId}")
    public BaseResponse getUser(@PathVariable("userId") @ApiParam(value = "用户Id",required = true) int userId) {
        if (1 > userId) {
            logger.warn("非法参数，请重试");
            return new BaseResponse(ResponseStatus.BAD_PARAM, "非法参数，请重试");
        }
        return userService.getUser(userId);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping("/modify")
    public BaseResponse modifyUser(@RequestBody  UserRequest userRequest) {
        if (null == userRequest) {
            logger.warn("非法参数，请重试");
            return new BaseResponse(ResponseStatus.BAD_PARAM, "非法参数，请重试");
        }
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userService.modifyUser(user);
    }

    @ApiOperation(value = "添加用户信息")
    @PostMapping("/add")
    public BaseResponse addUser(@RequestBody UserRequest userRequest) {
        if (null == userRequest) {
            logger.warn("非法参数，请重试");
            return new BaseResponse(ResponseStatus.BAD_PARAM, "非法参数，请重试");
        }
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userService.addUser(user);
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping("/remove/{userId}")
    public BaseResponse removeUser(@PathVariable("userId") @ApiParam(value = "用户id", required = true) int userId) {
        if (1 > userId) {
            logger.warn("非法参数，请重试");
            return new BaseResponse(ResponseStatus.BAD_PARAM, "非法参数，请重试");
        }
        return userService.removeUser(userId);
    }

}

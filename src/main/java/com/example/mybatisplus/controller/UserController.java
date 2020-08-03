package com.example.mybatisplus.controller;


import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author minfc
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    /**
     * 查询所有人员
     *
     * @param user user
     * @return List<User>
     */
    @PostMapping("/listUser")
    public List<User> listUser(@RequestBody User user) {
        return userService.list();
    }
}

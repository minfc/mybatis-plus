package com.example.mybatisplus.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatisplus.entity.MaUser;
import com.example.mybatisplus.service.MaUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "权限管理")
@RestController
public class QxglController {
    @Autowired
    private MaUserService userService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login/{username}/{password}", method = RequestMethod.POST)
    public String login(@ApiParam(value = "用户名") @PathVariable String username, @ApiParam(value = "密码") @PathVariable String password) {
        return userService.login(username, password);
    }

    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "QueryUserInfo", method = RequestMethod.POST)
    public JSONArray queryUserInfo(@ApiParam(value = "token") @RequestBody String token) {
        return userService.queryUserInfo(token);
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "changePassWord", method = RequestMethod.POST)
    public Object changePassWord(@ApiParam(value = "角色标识码") @RequestBody MaUser user, @RequestParam String password) {
        return userService.updateByPassword(user, password);
    }

    @ApiOperation(value = "查看所有用户信息")
    @RequestMapping(value = "seeUser", method = RequestMethod.GET)
    public Object seeUser() {
        return userService.list(null);
    }

    @ApiOperation(value = "新增/修改指定用户信息")
    @RequestMapping(value = "changeUser", method = RequestMethod.POST)
    public Object changeUser(@ApiParam(value = "用户信息") @RequestBody MaUser user) {
        if (StringUtils.isNotEmpty(user.getBsm())) {
            return userService.update(user, null);
        } else {
            return userService.save(user);
        }
    }

    @ApiOperation(value = "删除用户信息")
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    public Object deleteUser(@ApiParam(value = "角色标识码") @RequestBody String bsm) {
            return userService.removeById(bsm);
    }
}

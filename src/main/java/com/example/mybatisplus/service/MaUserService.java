package com.example.mybatisplus.service;

import com.alibaba.fastjson.JSONArray;
import com.example.mybatisplus.entity.MaUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
public interface MaUserService extends IService<MaUser> {

    String login(String username, String password);

    JSONArray queryUserInfo(String token);

    Object updateByPassword(MaUser user, String password);

    MaUser selectByXm(String username);
}

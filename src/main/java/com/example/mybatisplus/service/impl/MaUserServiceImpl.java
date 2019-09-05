package com.example.mybatisplus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.example.mybatisplus.config.shiro.JwtUtil;
import com.example.mybatisplus.entity.MaRole;
import com.example.mybatisplus.entity.MaUser;
import com.example.mybatisplus.mapper.MaMenuMapper;
import com.example.mybatisplus.mapper.MaRoleMapper;
import com.example.mybatisplus.mapper.MaUserMapper;
import com.example.mybatisplus.service.MaUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Service
public class MaUserServiceImpl extends ServiceImpl<MaUserMapper, MaUser> implements MaUserService {
    @Autowired
    private MaUserMapper userMapper;
    @Autowired
    private MaRoleMapper roleMapper;
    @Autowired
    private MaMenuMapper menuMapper;

    @Override
    public String login(String username, String password) {
        MaUser user = userMapper.selectByJy(username, password);
        if (user != null) {
            return JwtUtil.sign(username, password);
        } else {
            return "false";
        }
    }

    @Override
    public JSONArray queryUserInfo(String token) {
        String username = JwtUtil.getUsername(token);
        MaUser userBean = userMapper.selectByXm(username);
        String UserBsm = userBean.getBsm();
        MaRole role = roleMapper.queryRoleWithYh(UserBsm);
        String roleBsm = role.getBsm();
        JSONArray array = (JSONArray) JSONArray.toJSON(menuMapper.queryJsWithMenu(roleBsm));
        JSONArray arrayResult = TreeUtil.arrayToTree(array, "bsm", "parentBsm", "children");
        arrayResult.add(role);
        arrayResult.add(userBean);
        return arrayResult;
    }

    @Override
    public Object updateByPassword(MaUser record, String password) {
        MaUser user = userMapper.selectById(record.getBsm());
        if (password.equals(user.getPassword())) {
            return userMapper.updateById(record);
        } else {
            return "原密码不正确";
        }
    }

    @Override
    public MaUser selectByXm(String username) {
        return userMapper.selectByXm(username);
    }
}

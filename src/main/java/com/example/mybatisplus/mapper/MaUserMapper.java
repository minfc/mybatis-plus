package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.MaUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
public interface MaUserMapper extends BaseMapper<MaUser> {

    MaUser selectByJy(String username, String password);

    MaUser selectByXm(String username);
}

package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.MaRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
public interface MaRoleMapper extends BaseMapper<MaRole> {

    MaRole queryRoleWithYh(String userBsm);
}

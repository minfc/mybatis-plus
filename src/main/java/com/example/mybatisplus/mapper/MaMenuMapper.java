package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.MaMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
public interface MaMenuMapper extends BaseMapper<MaMenu> {

    Object queryJsWithMenu(String roleBsm);
}

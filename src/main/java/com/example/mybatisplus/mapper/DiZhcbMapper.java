package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.DiZhcb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 综合词表 Mapper 接口
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Mapper
public interface DiZhcbMapper extends BaseMapper<DiZhcb> {

    List<DiZhcb> getHqXlkType(@Param("id")Integer id);
}

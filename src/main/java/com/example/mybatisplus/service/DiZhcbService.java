package com.example.mybatisplus.service;

import com.example.mybatisplus.entity.DiZhcb;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 综合词表 服务类
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
public interface DiZhcbService extends IService<DiZhcb> {

    List<DiZhcb> getHqXlkType(Integer id);
}

package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.DiZhcb;
import com.example.mybatisplus.mapper.DiZhcbMapper;
import com.example.mybatisplus.service.DiZhcbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 综合词表 服务实现类
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Service
public class DiZhcbServiceImpl extends ServiceImpl<DiZhcbMapper, DiZhcb> implements DiZhcbService {
@Autowired
private DiZhcbMapper diZhcbMapper;

    @Override
    public List<DiZhcb> getHqXlkType(Integer id) {
        return diZhcbMapper.getHqXlkType(id);
    }

}

package com.example.mybatisplus.controller;

import com.example.mybatisplus.entity.DiZhcb;
import com.example.mybatisplus.service.DiZhcbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: minfanchao
 * @Date: 2019/7/22 15:12
 * @Description:
 */
@Api(tags = "综合词表")
@RestController
public class ZhcbController {
    @Autowired
    private DiZhcbService diZhcbService;

    /**
     * @return List<Zhcb>
     */
    @ApiOperation(value = "查看字典类型")
    @RequestMapping(value = "selectZhcb", method = RequestMethod.GET)
    public List<DiZhcb> selectXlkType() {
        return diZhcbService.list(null);
    }

    /*
     * @return List<Zhcb>
     */
    @ApiOperation(value = "获取字典")
    @RequestMapping(value = "getZhcb", method = RequestMethod.POST)
    public List<DiZhcb> getZhcb(Integer id) {
        return diZhcbService.getHqXlkType(id);
    }

}

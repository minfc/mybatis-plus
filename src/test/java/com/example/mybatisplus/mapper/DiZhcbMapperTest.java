package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.DiZhcb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiZhcbMapperTest {
    @Autowired
    private DiZhcbMapper diZhcbMapper;

    @Test
    public void getHqXlkTypeTest() throws SQLException {
        List<DiZhcb> diZhcbList = diZhcbMapper.getHqXlkType(11500);
        System.out.println(diZhcbList);
    }
}

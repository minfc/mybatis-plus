package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.DiZhcb;
import com.example.mybatisplus.entity.MaUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
@Transactional  //事务管理，默认回滚,如果配置了多数据源记得指定事务管理器
@DisplayName("Test DiZhcbMapper")
class DiZhcbyMapperTest {
    @Autowired
    private DiZhcbMapper diZhcbMapper;

    //@BeforeAll    只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前。
    //@BeforeEach   在每个测试执行之前执行。
    //@AfterEach    在每个测试执行之后执行。
    //@AfterAll     只执行一次，执行时机是在所有测试和。
    //@AfterEach    注解方法之后。
    @BeforeAll
    void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void getHqXlkTypeTest() throws SQLException {
        List<DiZhcb> diZhcbList = diZhcbMapper.getHqXlkType(11500);
        System.out.println(diZhcbList);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}

package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.MaUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
@Transactional  //事务管理，默认回滚,如果配置了多数据源记得指定事务管理器
@DisplayName("Test DiZhcbMapper")
class MaUserMapperTest {
    @Autowired
    private MaUserMapper maUserMapper;

    private static MaUser user;

    @BeforeAll
    static void initAll() {
        user = new MaUser();
        user.setUsername("admin");
        user.setPassword("admin");
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectByJy() {
        MaUser dbuser = maUserMapper.selectByJy(user.getUsername(), user.getPassword());
        assertAll("Select User Success.",
                () -> assertNotNull(dbuser),
                () -> assertNotNull(dbuser.getBsm()));
        System.out.println(dbuser);
    }

    @Test
    void selectByXm() {
        MaUser dbuser = maUserMapper.selectByXm(user.getUsername());
        assertAll("Select User Success.",
                () -> assertNotNull(dbuser),
                () -> assertNotNull(dbuser.getBsm()));
        System.out.println(dbuser);
    }
}

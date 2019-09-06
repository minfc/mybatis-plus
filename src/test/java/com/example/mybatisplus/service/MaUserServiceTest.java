package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.MaUser;
import com.example.mybatisplus.mapper.MaUserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
@DisplayName("Test MaUserService")
class MaUserServiceTest {
    @Autowired
    private MaUserService maUserService;

    @BeforeAll
    static void initAll() {
     /*   user = new MaUser();
        user.setUsername("test");
        user.setPassword("test");*/
    }


    @Test
    @DisplayName("Test insert")
    void insetUser() {
        MaUser user = new MaUser();
        user.setUsername("test");
        user.setPassword("test");
        user.setFlag("1");
        Boolean isSuccess = maUserService.save(user);
        System.out.println(isSuccess);
    }

    @Test
    @DisplayName("Test select")
    void qureyUser() {
        QueryWrapper<MaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "test").eq("password", "test");
        MaUser dbuser = maUserService.getOne(queryWrapper);
        assertAll("Select User Success.",
                () -> assertNotNull(dbuser),
                () -> assertNotNull(dbuser.getUsername()),
                () -> assertNotNull(dbuser.getBsm()));
        assertEquals("test", dbuser.getUsername());
        assertEquals("test", dbuser.getPassword());
        System.out.println(dbuser);
    }

    @Test
    @DisplayName("Test update")
    void updateUser() {
        QueryWrapper<MaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "test").eq("password", "test");
        MaUser dbuser = maUserService.getOne(queryWrapper);
        dbuser.setUsername("test1");
        Boolean isSuccess = maUserService.updateById(dbuser);
        System.out.println(isSuccess);
    }

    @Test
    @DisplayName("Test delete")
    void deleteUser() {
        QueryWrapper<MaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "test1").eq("password", "test");
        MaUser dbuser = maUserService.getOne(queryWrapper);
        Boolean isSuccess = maUserService.removeById(dbuser);
        System.out.println(isSuccess);
    }
}

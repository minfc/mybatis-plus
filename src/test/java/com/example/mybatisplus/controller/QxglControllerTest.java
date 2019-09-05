package com.example.mybatisplus.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
@Transactional  //事务管理，默认回滚,如果配置了多数据源记得指定事务管理器
@DisplayName("Test QxglController")
class QxglControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void jyYh() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/test/login/{username}/{password}")
                .param("usernmae", "admin")
                .param("password", "admin")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())    //期望服务器端返回的信息
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }


    @Test
    void queryUserInfo() {
    }

    @Test
    void changePassWord() {
    }
}

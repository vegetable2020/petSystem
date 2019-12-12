package com.jyu.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetControllerTest {
    //由spring容器自动注入web上下文对象
    @Autowired
    private WebApplicationContext wac;
    //定义一个用于伪造mvc请求环境的对象
    private MockMvc mockMvc;
    //每个测试方法被调用之前都会先被调用
    //用于测试资源的初始化
    @Before
    public  void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
    //查询全部
    @Test
    public void queryAllTest() throws Exception {
        String list=mockMvc.perform(get("/queryall")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(list);
    }

    //新增
    @Test
    public void saveTest() throws Exception {
        String content="{\"id\":null,\"name\":\"哈士奇\",\"owner\":\"Tesla\",\"age\":\"2\"}";
        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    //修改
    @Test
    public void updateTest() throws Exception {
        String content="{\"id\":2,\"name\":\"泰迪\",\"owner\":\"Tom\",\"age\":\"3\"}";
        mockMvc.perform(put("/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    //详细查询
    @Test
    public void queryByIdTest() throws Exception {
        String list=mockMvc.perform(get("/querybyid/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(list);
    }

    //删除
    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/delete/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}

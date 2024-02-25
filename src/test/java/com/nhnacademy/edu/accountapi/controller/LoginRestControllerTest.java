package com.nhnacademy.edu.accountapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.accountapi.dto.LoginDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testDoLogin() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserId("admin");
        loginDto.setUserPassword("123");

        ObjectMapper objectMapper = new ObjectMapper();


        mockMvc.perform(post("/login").content(objectMapper.writeValueAsString(loginDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("로그인 성공")));
    }

    @Test
    void testFailLogin() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserId("admin");
        loginDto.setUserPassword("12345678");

        ObjectMapper objectMapper = new ObjectMapper();


        mockMvc.perform(post("/login").content(objectMapper.writeValueAsString(loginDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("로그인 실패")));
    }
}
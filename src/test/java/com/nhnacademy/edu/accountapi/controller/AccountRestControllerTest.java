package com.nhnacademy.edu.accountapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.accountapi.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void testCreateAccount() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Account input = new Account(1L, "kim", "1234", "kim@nhn.com", "김지윤", "가입");
        mockMvc.perform(post("/accounts").content(objectMapper.writeValueAsString(input))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId", equalTo("kim")))
                .andExpect(jsonPath("$.userName", equalTo("김지윤")));
    }

    @Test
    @Order(2)
    void testGetAccounts() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].userId", equalTo("admin")));
    }

    @Test
    @Order(3)
    void testGetAccount() throws Exception {
        mockMvc.perform(get("/accounts/{userId}", "admin"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userName", equalTo("관리자")));
    }

    @Test
    @Order(4)
    void testDeleteAccount() throws Exception {
        this.mockMvc.perform(delete("/accounts/{userId}", "kim"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("계정 삭제 완료")));

    }
}
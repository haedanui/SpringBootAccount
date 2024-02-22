package com.nhnacademy.edu.accountapi.service;

import com.nhnacademy.edu.accountapi.dto.LoginDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Test
    void TestUserMatch() {
        LoginDto loginDto = new LoginDto("admin", "123");

        boolean userMatch = loginService.userMatch(loginDto.getUserId(), loginDto.getUserPassword());

        Assertions.assertThat(userMatch).isTrue();

    }
}
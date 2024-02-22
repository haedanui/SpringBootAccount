package com.nhnacademy.edu.accountapi.controller;

import com.nhnacademy.edu.accountapi.domain.ResultResponse;
import com.nhnacademy.edu.accountapi.dto.LoginDto;
import com.nhnacademy.edu.accountapi.service.AccountService;
import com.nhnacademy.edu.accountapi.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginRestController {

    private final LoginService loginService;

    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResultResponse doLogin(@RequestBody LoginDto loginDto) {
        if (loginService.userMatch(loginDto.getUserId(), loginDto.getUserPassword())) {
            return new ResultResponse("로그인 성공");
        }
        else {
            return new ResultResponse("로그인 실패");
        }
    }
}

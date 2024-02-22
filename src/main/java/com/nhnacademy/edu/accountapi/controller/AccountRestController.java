package com.nhnacademy.edu.accountapi.controller;

import com.nhnacademy.edu.accountapi.domain.Account;
import com.nhnacademy.edu.accountapi.domain.ResultResponse;
import com.nhnacademy.edu.accountapi.dto.AccountCreateDto;
import com.nhnacademy.edu.accountapi.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody AccountCreateDto accountCreateDto) {
        return accountService.createAccount(accountCreateDto);
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{userId}")
    public Account getAccount(@PathVariable("userId") String userId) {
        return accountService.getAccount(userId);
    }

    @DeleteMapping("/{userId}")
    public ResultResponse deleteAccount(@PathVariable("userId") String userId) {
        accountService.deleteAccount(userId);
        return new ResultResponse("계정 삭제 완료");
    }

}

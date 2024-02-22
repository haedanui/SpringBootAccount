package com.nhnacademy.edu.accountapi.service;

import com.nhnacademy.edu.accountapi.domain.Account;
import com.nhnacademy.edu.accountapi.dto.AccountCreateDto;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts(); // 전체 계정 조회

    Account createAccount(AccountCreateDto accountCreateDto); // 계정 생성

    Account getAccount(String userId); // userId로 계정 조회

    void deleteAccount(String userId); // userId로 계정 삭제
}

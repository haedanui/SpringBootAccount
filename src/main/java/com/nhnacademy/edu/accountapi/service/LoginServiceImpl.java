package com.nhnacademy.edu.accountapi.service;

import com.nhnacademy.edu.accountapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final AccountRepository accountRepository;

    public LoginServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public boolean userMatch(String userId, String userPassword) {
        return accountRepository.existsAccountByUserIdAndUserPassword(userId, userPassword);
    }

}

package com.nhnacademy.edu.accountapi.service;

import com.nhnacademy.edu.accountapi.domain.Account;
import com.nhnacademy.edu.accountapi.dto.AccountCreateDto;
import com.nhnacademy.edu.accountapi.exception.AccountAlreadyExistsException;
import com.nhnacademy.edu.accountapi.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(AccountCreateDto accountCreateDto) {
        if(accountRepository.existsAccountByUserId(accountCreateDto.getUserId())) {
            throw new AccountAlreadyExistsException();
        }

        Account account = new Account();
        account.setUserId(accountCreateDto.getUserId());
        account.setUserPassword(accountCreateDto.getUserPassword());
        account.setUserEmail(accountCreateDto.getUserEmail());
        account.setUserName(accountCreateDto.getUserName());
        account.setUserStatus("가입");

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(String userId) {
        return accountRepository.findAccountByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteAccount(String userId) {
        accountRepository.deleteAccountByUserId(userId);
    }

}

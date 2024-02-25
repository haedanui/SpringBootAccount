package com.nhnacademy.edu.accountapi.repository;

import com.nhnacademy.edu.accountapi.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void testFindAccountByUserId() throws Exception {
        Account account = new Account(1L, "kim", "1234", "kim@nhn.com", "김지윤", "가입");
        entityManager.merge(account);

        Account actual = accountRepository.findAccountByUserId("kim");

        Assertions.assertThat(actual.getUserId()).isEqualTo(account.getUserId());
    }

    @Test
    void testExistsAccountByUserId() throws Exception {
        String userId = "admin";
        boolean existsAccount = accountRepository.existsAccountByUserId(userId);

        Assertions.assertThat(existsAccount).isTrue();

    }

    @Test
    void testDeleteAccountByUserId() throws Exception {
        String userId = "admin";
        accountRepository.deleteAccountByUserId(userId);

        boolean existsAccount = accountRepository.existsAccountByUserId(userId);

        Assertions.assertThat(existsAccount).isFalse();


    }

    @Test
    void testExistsAccountByUserIdAndUserPassword() throws Exception {
        String userId = "admin";
        String userPassword = "123";

        boolean existsAccount = accountRepository.existsAccountByUserIdAndUserPassword(userId, userPassword);

        Assertions.assertThat(existsAccount).isTrue();
    }
}
package com.nhnacademy.edu.accountapi.repository;

import com.nhnacademy.edu.accountapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByUserId(String userId);

    boolean existsAccountByUserId(String userId);

    void deleteAccountByUserId(String userId);

    boolean existsAccountByUserIdAndUserPassword(String userId, String userPassword);
}

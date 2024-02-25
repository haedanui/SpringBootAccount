package com.nhnacademy.edu.accountapi.service;

public interface LoginService {
    boolean userMatch(String userId, String userPassword); // 로그인 시 user 확인
}

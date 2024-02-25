package com.nhnacademy.edu.accountapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userName;
}

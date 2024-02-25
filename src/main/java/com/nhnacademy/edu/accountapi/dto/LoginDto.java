package com.nhnacademy.edu.accountapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String userId;
    private String userPassword;
}

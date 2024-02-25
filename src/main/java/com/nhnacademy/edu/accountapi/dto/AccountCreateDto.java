package com.nhnacademy.edu.accountapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {
//    @JsonProperty("userId")
    private String userId;
//    @JsonProperty("userPassword")
    private String userPassword;
//    @JsonProperty("userEmail")
    private String userEmail;
//    @JsonProperty("userName")
    private String userName;
}

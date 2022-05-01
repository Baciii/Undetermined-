package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterFormDTO {
    private String account;
    private String password;
    private String again_password;
}

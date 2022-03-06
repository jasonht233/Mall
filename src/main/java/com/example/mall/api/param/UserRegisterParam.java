package com.example.mall.api.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterParam {

    @NotBlank(message = "Login Name cannot be empty")
    private String loginName;

    @NotBlank(message = "password cannot be empty")
    private String password;
}

package com.mirjalolcode.expensetracker.rest;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UserLoginRequest {

    @NotBlank
    String email;
    @NotBlank
    String password;
}
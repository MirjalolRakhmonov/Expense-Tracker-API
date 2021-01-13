package com.mirjalolcode.expensetracker.rest;

import lombok.Value;

@Value
public class UserLoginRequest {
    String email;
    String password;
}
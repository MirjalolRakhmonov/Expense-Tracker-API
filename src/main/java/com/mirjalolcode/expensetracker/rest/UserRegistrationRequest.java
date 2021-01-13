package com.mirjalolcode.expensetracker.rest;

import lombok.Value;

@Value
public class UserRegistrationRequest {
    String firstName;
    String lastName;
    String email;
    String password;
}
package com.mirjalolcode.expensetracker.rest;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
public class UserRegistrationRequest {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Email
    String email;
    @NotBlank
    String password;
}
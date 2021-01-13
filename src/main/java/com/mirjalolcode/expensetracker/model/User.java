package com.mirjalolcode.expensetracker.model;

import lombok.Value;

@Value
public class User {
	Integer userId;
	String firstName;
	String lastName;
	String email;
	String password;
}
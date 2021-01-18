package com.mirjalolcode.expensetracker.model;

import lombok.Value;

@Value
public class User {
	Integer userId;
	String firstName;
	String lastName;
	String email;
	String password;

	public User(int user_id, String first_name, String last_name, String email, String password) {

	}
}
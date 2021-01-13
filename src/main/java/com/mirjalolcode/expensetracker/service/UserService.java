package com.mirjalolcode.expensetracker.service;

import com.mirjalolcode.expensetracker.exception.EtAuthException;
import com.mirjalolcode.expensetracker.model.User;

public interface UserService {

	User validateUser(String email, String password) throws EtAuthException;
	
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}

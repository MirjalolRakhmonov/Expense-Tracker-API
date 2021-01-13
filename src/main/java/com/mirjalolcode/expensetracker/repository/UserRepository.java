package com.mirjalolcode.expensetracker.repository;

import com.mirjalolcode.expensetracker.exception.EtAuthException;
import com.mirjalolcode.expensetracker.model.User;

public interface UserRepository {

	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	
	User findByEmailAndPassword(String email, String password) throws EtAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer userId);
}

package com.mirjalolcode.expensetracker.repository;

import com.mirjalolcode.expensetracker.exception.EtAuthException;
import com.mirjalolcode.expensetracker.model.User;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public Integer create(String firstName, String lastName, String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCountByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

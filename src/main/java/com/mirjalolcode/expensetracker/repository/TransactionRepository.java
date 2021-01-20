package com.mirjalolcode.expensetracker.repository;

import com.mirjalolcode.expensetracker.exception.EtBadRequestException;
import com.mirjalolcode.expensetracker.exception.EtResourceNotFoundException;
import com.mirjalolcode.expensetracker.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> findAll(Integer userId) throws EtResourceNotFoundException;

    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws
            EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws
            EtBadRequestException;

    void removeById (Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}

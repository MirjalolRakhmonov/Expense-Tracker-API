package com.mirjalolcode.expensetracker.repository;

import com.mirjalolcode.expensetracker.exception.EtResourceNotFoundException;
import com.mirjalolcode.expensetracker.exception.EtBadRequestException;
import com.mirjalolcode.expensetracker.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId);

}

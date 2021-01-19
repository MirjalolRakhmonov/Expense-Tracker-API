package com.mirjalolcode.expensetracker.service;

import com.mirjalolcode.expensetracker.exception.EtResourceNotFoundException;
import com.mirjalolcode.expensetracker.exception.EtBadRequestException;
import com.mirjalolcode.expensetracker.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    void removeWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}

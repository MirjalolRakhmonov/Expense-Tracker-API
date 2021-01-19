package com.mirjalolcode.expensetracker.service;

import com.mirjalolcode.expensetracker.exception.EtResourceNotFoundException;
import com.mirjalolcode.expensetracker.exception.EtBadRequestException;
import com.mirjalolcode.expensetracker.model.Category;
import com.mirjalolcode.expensetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        return null;
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        int categoryId = categoryRepository.create(userId, title, description);
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {

    }

    @Override
    public void removeWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException {

    }
}

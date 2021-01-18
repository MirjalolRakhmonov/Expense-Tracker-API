package com.mirjalolcode.expensetracker.model;

import lombok.Value;

@Value
public class Category {
    Integer categoryId;
    Integer userId;
    String title;
    String description;
    Double totalExpense;

    public Category(int category_id, int user_id, String title, String description, String total_expense) {

    }
}

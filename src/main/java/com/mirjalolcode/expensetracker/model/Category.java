package com.mirjalolcode.expensetracker.model;

import lombok.Value;

@Value
public class Category {
    Integer categoryId;
    Integer userId;
    String title;
    String description;
    Double totalExpense;
}

package org.sadmansakib.expensemanagement.category.domain;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id) {
        super("Category with id " + id + " not found");
    }
}

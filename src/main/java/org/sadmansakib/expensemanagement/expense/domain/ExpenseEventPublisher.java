package org.sadmansakib.expensemanagement.expense.domain;

import org.sadmansakib.expensemanagement.category.domain.ExpenseAddedInCategoryEvent;

public interface ExpenseEventPublisher {
    void expenseAdded(ExpenseAddedInCategoryEvent event);
}

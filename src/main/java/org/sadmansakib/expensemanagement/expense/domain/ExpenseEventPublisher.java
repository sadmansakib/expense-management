package org.sadmansakib.expensemanagement.expense.domain;

import org.sadmansakib.expensemanagement.category.domain.ExpenseAddedInCategoryEvent;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

public interface ExpenseEventPublisher {
    void expenseAdded(ExpenseAddedInCategoryEvent event);

    default void expenseAdded(Id categoryId, Amount amount){
        expenseAdded(new ExpenseAddedInCategoryEvent(categoryId, amount));
    }
}

package org.sadmansakib.expensemanagement.category.domain;

import org.sadmansakib.expensemanagement.budget.domain.BudgetSpent;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

public interface CategoryEventPublisher {
    void updateBudgetSpent(BudgetSpent event);

    default void updateBudgetSpent(Id budgetId, Amount spentAmount) {
        updateBudgetSpent(new BudgetSpent(budgetId, spentAmount));
    }
}

package org.sadmansakib.expensemanagement.budget.domain;

import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

public class BudgetNotFoundException extends RuntimeException {
    public BudgetNotFoundException(Id id) {
        super("Budget not found for id: " + id.get());
    }
}

package org.sadmansakib.expensemanagement.budget.domain;

import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.error.domain.ExpenseManagementException;

public class BudgetNotFoundException extends ExpenseManagementException {
    public BudgetNotFoundException(Id id) {
        super(STR."Budget not found for id: \{id.get()}", 404);
    }
}

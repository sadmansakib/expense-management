package org.sadmansakib.expensemanagement.budget.domain;

import org.sadmansakib.expensemanagement.shared.error.domain.ExpenseManagementException;

public class BudgetAlreadyExistsException extends ExpenseManagementException {
    public BudgetAlreadyExistsException(Budget.Month month, Budget.Year year) {
        super(STR."Budget already exists for month: \{month.get()} and year: \{year.get()}", 400);
    }
}

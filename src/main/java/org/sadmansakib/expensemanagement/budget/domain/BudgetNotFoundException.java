package org.sadmansakib.expensemanagement.budget.domain;

public class BudgetNotFoundException extends RuntimeException {
    public BudgetNotFoundException(Budget.BudgetId id) {
        super("Budget not found for id: " + id.get());
    }
}

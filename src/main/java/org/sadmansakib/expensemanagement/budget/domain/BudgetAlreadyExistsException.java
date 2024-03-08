package org.sadmansakib.expensemanagement.budget.domain;

public class BudgetAlreadyExistsException extends RuntimeException {
    public BudgetAlreadyExistsException(Budget.Month month, Budget.Year year) {
        super("Budget already exists for month: " + month.get() + " and year: " + year.get());
    }
}

package org.sadmansakib.expensemanagement.expense.domain;

import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface ExpenseRepository {
    Expense save(Expense expense);
}

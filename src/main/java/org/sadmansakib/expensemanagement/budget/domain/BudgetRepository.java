package org.sadmansakib.expensemanagement.budget.domain;

import org.jmolecules.ddd.types.Repository;

import java.util.Optional;

public interface BudgetRepository extends Repository<Budget, Budget.BudgetId> {
    Budget save(Budget budget);
    Optional<Budget> findByMonthAndYear(Budget.Month month, Budget.Year year);
}

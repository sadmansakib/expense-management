package org.sadmansakib.expensemanagement.budget.domain;

import org.jmolecules.ddd.types.Repository;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

import java.util.Optional;

public interface BudgetRepository extends Repository<Budget, Id> {
    Budget save(Budget budget);
    Optional<Budget> findByMonthAndYear(Budget.Month month, Budget.Year year);
    Optional<Budget> findById(Id id);
}

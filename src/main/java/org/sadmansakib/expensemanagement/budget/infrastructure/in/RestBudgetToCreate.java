package org.sadmansakib.expensemanagement.budget.infrastructure.in;

import jakarta.validation.constraints.NotNull;
import org.sadmansakib.expensemanagement.budget.domain.Budget;
import org.sadmansakib.expensemanagement.budget.domain.BudgetCreator;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;

public record RestBudgetToCreate(@NotNull Double totalAllocatedAmount,
                                 @NotNull String month,
                                 @NotNull Integer year) {
    public BudgetCreator.BudgetToCreate toDomain() {
        return new BudgetCreator.BudgetToCreate(new Amount(totalAllocatedAmount),
                new Budget.Month(month), new Budget.Year(year));
    }
}

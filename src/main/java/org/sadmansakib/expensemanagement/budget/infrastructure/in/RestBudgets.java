package org.sadmansakib.expensemanagement.budget.infrastructure.in;

import org.sadmansakib.expensemanagement.budget.domain.Budgets;

import java.util.Collection;

public record RestBudgets(Collection<RestBudget> budgets) {
    public RestBudgets {
        if (budgets == null) {
            throw new IllegalArgumentException("Budgets cannot be null");
        }
    }

    public static RestBudgets from(Budgets budgets) {
        return new RestBudgets(budgets.get().stream()
                .map(RestBudget::from).toList());
    }
}

package org.sadmansakib.expensemanagement.budget.infrastructure.in;

import lombok.Builder;
import org.sadmansakib.expensemanagement.budget.domain.Budget;

@Builder
public record RestBudget(Long id, Double totalAllocatedAmount,
                         Double totalSpentAmount, String month, Integer year) {

    public static RestBudget from(Budget budget) {
        return RestBudget.builder()
                .id(budget.id().get())
                .totalAllocatedAmount(budget.allocated().get())
                .totalSpentAmount(budget.spent().get())
                .month(budget.month().get())
                .year(budget.year().get())
                .build();
    }
}

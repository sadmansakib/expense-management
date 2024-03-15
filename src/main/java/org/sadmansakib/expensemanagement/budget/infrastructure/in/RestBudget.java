package org.sadmansakib.expensemanagement.budget.infrastructure.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.sadmansakib.expensemanagement.budget.domain.Budget;

@Builder
public record RestBudget(Long id, @NotNull Double allocated,
                         Double spent, String month, Integer year) {

    public static RestBudget from(Budget budget) {
        return RestBudget.builder()
                .id(budget.id().get())
                .allocated(budget.allocated().get())
                .spent(budget.spent().get())
                .month(budget.month().get())
                .year(budget.year().get())
                .build();
    }
}

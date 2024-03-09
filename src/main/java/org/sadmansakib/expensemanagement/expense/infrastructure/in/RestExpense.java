package org.sadmansakib.expensemanagement.expense.infrastructure.in;

import lombok.Builder;
import org.sadmansakib.expensemanagement.expense.domain.Expense;

import java.time.LocalDate;

@Builder
public record RestExpense(
        Long id,
        LocalDate date,
        String description,
        Double amount,
        Long categoryId
) {
    public static RestExpense from(Expense expense) {
        return RestExpense.builder()
                .id(expense.getId().get())
                .date(expense.getDate().get())
                .description(expense.getDescription().get())
                .amount(expense.getAmount().get())
                .categoryId(expense.getCategoryId().get())
                .build();
    }
}

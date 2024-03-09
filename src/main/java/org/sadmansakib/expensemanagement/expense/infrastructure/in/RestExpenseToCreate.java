package org.sadmansakib.expensemanagement.expense.infrastructure.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.sadmansakib.expensemanagement.expense.domain.Expense;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseCreator;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

import java.time.LocalDate;

@Slf4j
public record RestExpenseToCreate(
        @NotBlank
        String date,
        @NotBlank
        String description,
        @NotNull
        Double amount,
        @NotNull
        Long categoryId
) {
    ExpenseCreator.ExpenseToCreate toDomain() {
        return ExpenseCreator.ExpenseToCreate.builder()
                .date(new Expense.Date(LocalDate.parse(date)))
                .description(new Expense.Description(description))
                .amount(new Amount(amount))
                .category(new Id(categoryId))
                .build();
    }
}

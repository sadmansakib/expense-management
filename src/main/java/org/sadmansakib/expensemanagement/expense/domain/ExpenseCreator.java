package org.sadmansakib.expensemanagement.expense.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.sadmansakib.expensemanagement.category.domain.CategoryService;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@SecondaryPort
@Slf4j
@RequiredArgsConstructor
public class ExpenseCreator {
    private final ExpenseRepository expenses;
    private final CategoryService categories;
    private final ExpenseEventPublisher publisher;

    public Expense create(ExpenseToCreate expenseToCreate) {
        log.info("ExpenseCreator|create:: Creating expense: {}", expenseToCreate);
        categories.findById(expenseToCreate.category().get());
        return expenses.save(expenseToCreate.create())
                .then(expense -> {
                    var result = expense.added();
                    log.info("ExpenseCreator|create:: event fired for adding expense: {}", result);
                    publisher.expenseAdded(result.getCategoryId(), result.getAmount());
                    return result;
                });
    }

    @Builder
    public record ExpenseToCreate(Amount amount, Id category, Expense.Date date, Expense.Description description) {
        public Expense create() {
            return Expense.builder()
                    .amount(amount)
                    .categoryId(category)
                    .date(date)
                    .description(description)
                    .build();
        }
    }
}

package org.sadmansakib.expensemanagement.category.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@Slf4j
@RequiredArgsConstructor
@SecondaryPort
public class CategoryUpdater {
    private final CategoryRepository categories;

    public void addExpense(Id categoryId, Amount amount) {
        log.info("CategoryUpdater|addExpense:: Adding expense to category: {}", categoryId);
        categories.findById(categoryId.get())
                .ifPresentOrElse(category -> {
                    log.info("CategoryManagement|handleExpenseAdded:: found category: {}", category);
                    category = category.addSpent(amount);
                    log.info("CategoryManagement|handleExpenseAdded:: updated category: {}", category);
                    categories.save(category);
                }, () -> {
                    log.error("CategoryManagement|handleExpenseAdded:: category not found for id: {}", categoryId.get());
                    throw new CategoryNotFoundException(categoryId.get());
                });
    }
}

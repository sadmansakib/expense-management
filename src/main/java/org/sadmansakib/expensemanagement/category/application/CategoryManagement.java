package org.sadmansakib.expensemanagement.category.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.budget.domain.BudgetService;
import org.sadmansakib.expensemanagement.category.domain.*;
import org.sadmansakib.expensemanagement.category.domain.CategoryExpenseAdded;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Service
@PrimaryPort
@Slf4j
@Component
public class CategoryManagement {
    private final CategoryRepository categories;
    private final CategoryCreator creator;

    public CategoryManagement(CategoryRepository categories, BudgetService budgets) {
        this.categories = categories;
        creator = new CategoryCreator(categories, budgets);
    }

    public Category create(CategoryCreator.CategoryToCreate categoryToCreate) {
        log.info("CategoryManagement|create:: categoryToCreate: {}", categoryToCreate);
        return creator.create(categoryToCreate);
    }

    public Categories findAll() {
        return new Categories(categories.findAll());
    }

    public Categories findAllByBudgetId(Long budgetId) {
        log.info("CategoryManagement|findAllByBudgetId:: fetching categories with budgetId: {}", budgetId);
        return new Categories(categories.findAllByBudgetId(budgetId));
    }

    @ApplicationModuleListener
    @Async
    void handleExpenseAdded(CategoryExpenseAdded event) {
        log.info("CategoryManagement|handleExpenseAdded:: received event: {}", event);
        categories.findById(event.categoryId().id())
                .ifPresentOrElse(category -> {
                    log.info("CategoryManagement|handleExpenseAdded:: found category: {}", category);
                    category = category.addSpent(event.spent());
                    log.info("CategoryManagement|handleExpenseAdded:: updated category: {}", category);
                    categories.save(category);
                }, () -> {
                    log.error("CategoryManagement|handleExpenseAdded:: category not found for id: {}", event.categoryId());
                    throw new CategoryNotFoundException(event.categoryId().get());
                });
    }
}

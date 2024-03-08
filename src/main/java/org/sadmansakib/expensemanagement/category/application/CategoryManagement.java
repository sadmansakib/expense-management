package org.sadmansakib.expensemanagement.category.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.budget.domain.BudgetService;
import org.sadmansakib.expensemanagement.category.domain.Category;
import org.sadmansakib.expensemanagement.category.domain.CategoryCreator;
import org.sadmansakib.expensemanagement.category.domain.CategoryRepository;
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
}

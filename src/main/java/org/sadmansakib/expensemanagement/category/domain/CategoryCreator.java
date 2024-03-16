package org.sadmansakib.expensemanagement.category.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.sadmansakib.expensemanagement.budget.domain.BudgetService;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;

@SecondaryPort
@RequiredArgsConstructor
@Slf4j
public class CategoryCreator {

    private final CategoryRepository categories;
    private final BudgetService budgets;

    public Category create(CategoryToCreate categoryToCreate) {
        log.info("CategoryCreator|create:: categoryToCreate: {}", categoryToCreate);
        budgets.checkBudgetExists(categoryToCreate.budgetId);
        var createdCategory = categories.save(categoryToCreate.create(categoryToCreate.budgetId));
        log.info("CategoryCreator|create:: createdCategory: {}", createdCategory);
        return createdCategory;
    }

    @Builder
    public record CategoryToCreate(Name name,
                                   Category.CategoryDescription description,
                                   Amount allocated,
                                   Id budgetId) {
        public Category create(Id budgetId) {
            return Category.builder()
                    .name(name)
                    .description(description)
                    .allocated(allocated)
                    .spent(Amount.zero())
                    .budgetId(budgetId)
                    .build();
        }
    }
}

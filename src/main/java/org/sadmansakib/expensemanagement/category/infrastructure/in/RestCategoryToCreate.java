package org.sadmansakib.expensemanagement.category.infrastructure.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.sadmansakib.expensemanagement.category.domain.Category;
import org.sadmansakib.expensemanagement.category.domain.CategoryCreator;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

public record RestCategoryToCreate(@NotBlank String name, String description,
                                   @NotNull Long budgetId, @NotNull Double allocatedAmount, Double spentAmount) {

    public CategoryCreator.CategoryToCreate toDomain() {
        return CategoryCreator.CategoryToCreate.builder()
                .budgetId(new Id(budgetId))
                .description(new Category.CategoryDescription(description))
                .name(new Category.CategoryName(name))
                .totalAllocatedAmount(new Amount(allocatedAmount))
                .build();
    }
}

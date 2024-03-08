package org.sadmansakib.expensemanagement.category.infrastructure.in;

import lombok.Builder;
import org.sadmansakib.expensemanagement.category.domain.Category;

@Builder
public record RestCategory(Long id, String name, String description,
                           Double allocatedAmount, Double spentAmount, Long budgetId) {
    public static RestCategory from(Category category) {
        return RestCategory.builder()
                .id(category.id().get())
                .name(category.name().get())
                .description(category.description().get())
                .allocatedAmount(category.allocated().get())
                .spentAmount(category.spent().get())
                .budgetId(category.budgetId().get())
                .build();
    }
}

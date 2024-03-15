package org.sadmansakib.expensemanagement.category.infrastructure.in;

import lombok.Builder;
import org.sadmansakib.expensemanagement.category.domain.Category;

@Builder
public record RestCategory(Long id, String name, String description,
                           Double allocated, Double spent, Long budgetId) {
    public static RestCategory from(Category category) {
        return RestCategory.builder()
                .id(category.id().get())
                .name(category.name().get())
                .description(category.description().get())
                .allocated(category.allocated().get())
                .spent(category.spent().get())
                .budgetId(category.budgetId().get())
                .build();
    }
}

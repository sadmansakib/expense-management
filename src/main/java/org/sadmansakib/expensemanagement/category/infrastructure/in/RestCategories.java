package org.sadmansakib.expensemanagement.category.infrastructure.in;

import org.sadmansakib.expensemanagement.category.domain.Categories;

import java.util.Collection;

public record RestCategories(Collection<RestCategory> categories) {
    public RestCategories {
        if (categories == null) {
            throw new IllegalArgumentException("Categories cannot be null");
        }
    }

    public static RestCategories from(Categories categories) {
        return new RestCategories(categories.get().stream()
                .map(RestCategory::from).toList());
    }
}

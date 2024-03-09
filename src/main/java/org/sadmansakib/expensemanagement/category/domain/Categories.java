package org.sadmansakib.expensemanagement.category.domain;

import java.util.Collection;

public record Categories(Collection<Category> categories) {
    public Categories {
        if (categories == null) {
            throw new IllegalArgumentException("Categories cannot be null");
        }
    }

    public Collection<Category> get(){
        return categories;
    }
}

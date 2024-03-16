package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnit;

public record RestGroceryItemUnit(Long id, String name) {
    static RestGroceryItemUnit fromDomain(GroceryItemUnit unit) {
        return new RestGroceryItemUnit(unit.id().get(), unit.name().get());
    }
}

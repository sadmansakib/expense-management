package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnitCreator;

public record RestGroceryItemUnitToCreate(String name) {
    GroceryItemUnitCreator.GroceryItemUnitToCreate toDomain(){
        return new GroceryItemUnitCreator.GroceryItemUnitToCreate(name);
    }
}

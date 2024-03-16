package org.sadmansakib.expensemanagement.grocery.domain;

import java.util.Collection;

public record GroceryItemUnits(Collection<GroceryItemUnit> units) {
    public Collection<GroceryItemUnit> get() {
        return units;
    }
}

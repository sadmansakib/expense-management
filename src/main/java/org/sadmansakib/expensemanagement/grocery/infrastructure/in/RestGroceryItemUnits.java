package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnits;

import java.util.Collection;

public record RestGroceryItemUnits(Collection<RestGroceryItemUnit> units) {

    public Collection<RestGroceryItemUnit> get() {
        return units;
    }

    public static RestGroceryItemUnits fromDomain(GroceryItemUnits units) {
        return new RestGroceryItemUnits(units.units().stream().map(RestGroceryItemUnit::fromDomain).toList());
    }
}

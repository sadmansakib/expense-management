package org.sadmansakib.expensemanagement.grocery.domain;

import java.util.Collection;

public record GroceryLists(Collection<GroceryList> groceryLists) {
    public Collection<GroceryList> get() {
        return groceryLists;
    }
}

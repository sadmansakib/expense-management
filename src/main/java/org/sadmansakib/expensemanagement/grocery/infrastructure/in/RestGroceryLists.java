package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import org.sadmansakib.expensemanagement.grocery.domain.GroceryLists;

import java.util.Collection;

public record RestGroceryLists(Collection<RestGroceryList> groceryLists) {

    public Collection<RestGroceryList> get() {
        return groceryLists;
    }

    public static RestGroceryLists from(GroceryLists groceryLists) {
        return new RestGroceryLists(
                groceryLists.get().stream()
                        .map(RestGroceryList::from)
                        .toList()
        );
    }
}

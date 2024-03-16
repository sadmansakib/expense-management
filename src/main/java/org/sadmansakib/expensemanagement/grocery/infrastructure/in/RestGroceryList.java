package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import org.sadmansakib.expensemanagement.grocery.domain.GroceryList;

public record RestGroceryList(
        Long id,
        String name,
        String type,
        Double total,
        Double estimated,
        String shoppingDate
) {

    static RestGroceryList from(GroceryList groceryList) {
        return new RestGroceryList(
                groceryList.id().get(),
                groceryList.name().get(),
                groceryList.type().name(),
                groceryList.paid().get(),
                groceryList.estimated().get(),
                groceryList.shoppingDate().get().toString()
        );
    }
}

package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import jakarta.validation.constraints.NotBlank;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryList;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryListCreator;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;

import java.time.LocalDate;

public record RestGroceryListToCreate(
        @NotBlank
        String name,
        @NotBlank
        String type,
        Double estimated,
        @NotBlank
        String shoppingDate
) {

    public RestGroceryListToCreate {
        if (estimated == null) {
            estimated = 0.0;
        }
    }

    public GroceryListCreator.GroceryListToCreate toDomain() {
        return GroceryListCreator.GroceryListToCreate.builder()
                .name(new GroceryList.Name(name))
                .type(GroceryList.Type.valueOf(type.toUpperCase()))
                .estimated(new Amount(estimated))
                .shoppingDate(new GroceryList.Date(LocalDate.parse(shoppingDate)))
                .build();
    }
}

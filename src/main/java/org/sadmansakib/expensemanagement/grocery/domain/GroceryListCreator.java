package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroceryListCreator {
    private final GroceryListRepository groceries;

    public GroceryList create(GroceryListToCreate groceryListToCreate) {
        log.info("GroceryListCreator|create:: groceryListToCreate: {}", groceryListToCreate);
        var domain = groceryListToCreate.create();
        log.info("GroceryListCreator|create:: created domain: {}", domain);
        domain = groceries.save(domain);
        log.info("GroceryListCreator|create:: saved domain: {}", domain);
        return domain;
    }

    @Builder
    public record GroceryListToCreate(Name name, GroceryList.Type type,
                                      Amount paid, Amount estimated, GroceryList.Date shoppingDate) {
        public GroceryList create() {
            var listBuilder = GroceryList.builder()
                    .name(name)
                    .type(type)
                    .estimated(estimated)
                    .shoppingDate(shoppingDate);
            if (Objects.nonNull(paid)) {
                listBuilder.paid(paid);
            } else {
                listBuilder.paid(new Amount(0.0));
            }
            return listBuilder.build();
        }
    }
}

package org.sadmansakib.expensemanagement.grocery.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryList;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryListCreator;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryListRepository;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryLists;
import org.springframework.stereotype.Component;

@Component
@Service
@Slf4j
@Port
public class GroceryListManagement {
    private final GroceryListRepository groceries;
    private final GroceryListCreator creator;

    public GroceryListManagement(GroceryListRepository groceries) {
        this.groceries = groceries;
        this.creator = new GroceryListCreator(groceries);
    }

    public GroceryList create(GroceryListCreator.GroceryListToCreate groceryListToCreate) {
        log.info("GroceryListManagement|create:: groceryListToCreate: {}", groceryListToCreate);
        var domain = creator.create(groceryListToCreate);
        log.info("GroceryListManagement|create:: created domain: {}", domain);
        return domain;
    }

    public GroceryLists history() {
        log.info("GroceryListManagement|history:: fetching all grocery lists");
        return new GroceryLists(groceries.history());
    }
}

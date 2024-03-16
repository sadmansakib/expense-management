package org.sadmansakib.expensemanagement.grocery.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnit;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnitCreator;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnitRepository;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnits;
import org.springframework.stereotype.Component;

@Service
@Port
@Component
@Slf4j
public class GroceryItemUnitManagement {
    private final GroceryItemUnitRepository units;
    private final GroceryItemUnitCreator creator;

    public GroceryItemUnitManagement(GroceryItemUnitRepository units) {
        this.units = units;
        creator = new GroceryItemUnitCreator(units);
    }

    public GroceryItemUnit create(GroceryItemUnitCreator.GroceryItemUnitToCreate groceryItemUnitToCreate) {
        log.info("GroceryItemUnitManagement|create:: groceryItemUnitToCreate: {}", groceryItemUnitToCreate);
        var domain = creator.create(groceryItemUnitToCreate);
        log.info("GroceryItemUnitManagement|create:: created domain: {}", domain);
        return domain;
    }

    public GroceryItemUnits all() {
        log.info("GroceryItemUnitManagement|all:: fetching all grocery item units");
        return new GroceryItemUnits(units.all());
    }
}

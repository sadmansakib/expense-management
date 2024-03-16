package org.sadmansakib.expensemanagement.grocery.domain;

import org.jmolecules.ddd.annotation.Repository;

import java.util.Collection;

@Repository
public interface GroceryItemUnitRepository {
    GroceryItemUnit save(GroceryItemUnit groceryItemUnit);
    Collection<GroceryItemUnit> all();
}

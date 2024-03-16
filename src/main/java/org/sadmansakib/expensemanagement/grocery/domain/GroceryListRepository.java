package org.sadmansakib.expensemanagement.grocery.domain;

import org.jmolecules.ddd.annotation.Repository;

import java.util.Collection;

@Repository
public interface GroceryListRepository {
    GroceryList save(GroceryList groceryList);
    Collection<GroceryList> history();
}

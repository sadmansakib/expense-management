package org.sadmansakib.expensemanagement.grocery.domain;

import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface GroceryItemRepository {
    GroceryItem save(GroceryItem item);
}

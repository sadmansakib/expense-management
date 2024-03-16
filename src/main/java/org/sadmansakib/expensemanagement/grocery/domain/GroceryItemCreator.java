package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.jmolecules.ddd.annotation.Service;

@SecondaryPort
@RequiredArgsConstructor
@Slf4j
@Service
public class GroceryItemCreator {
    private final GroceryItemRepository groceryItems;

    public GroceryItem create(GroceryItem item) {
        log.info("GroceryItemCreator|create:: groceryItem: {}", item);
        var saved = groceryItems.save(item);
        log.info("GroceryItemCreator|create:: saved: {}", saved);
        return saved;
    }
}

package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItem;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemRepository;
import org.springframework.stereotype.Component;

@Component
@Service
@RequiredArgsConstructor
@SecondaryAdapter
@Slf4j
public class GroceryItemRepositoryAdapter implements GroceryItemRepository {

    private final GroceryItemEntityRepository groceries;

    @Override
    public GroceryItem save(GroceryItem item) {
        log.info("GroceryItemRepositoryAdapter|save:: groceryItem: {}", item);
        var entity = GroceryItemEntity.fromDomain(item);
        log.info("GroceryItemRepositoryAdapter|save:: converted to entity: {}", entity);
        entity = groceries.save(entity);
        log.info("GroceryItemRepositoryAdapter|save:: saved entity: {}", entity);
        return entity.toDomain();
    }
}

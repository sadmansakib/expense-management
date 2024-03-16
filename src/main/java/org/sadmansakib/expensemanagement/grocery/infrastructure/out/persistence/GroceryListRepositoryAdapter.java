package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryList;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryListRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Component
@SecondaryAdapter
@Slf4j
@RequiredArgsConstructor
@Transactional
public class GroceryListRepositoryAdapter implements GroceryListRepository {

    private final GroceryListEntityRepository groceries;

    @Override
    public GroceryList save(GroceryList groceryList) {
        log.info("GroceryListRepositoryAdapter|save:: groceryList: {}", groceryList);
        var entity = GroceryListEntity.fromDomain(groceryList);
        log.info("GroceryListRepositoryAdapter|save:: converted to entity: {}", entity);
        entity = groceries.save(entity);
        log.info("GroceryListRepositoryAdapter|save:: saved entity: {}", entity);
        return entity.toDomain();
    }

    @Override
    public Collection<GroceryList> history() {
        log.info("GroceryListRepositoryAdapter|history:: fetching all grocery lists");
        return groceries.findAll()
                .stream()
                .map(GroceryListEntity::toDomain).toList();
    }
}

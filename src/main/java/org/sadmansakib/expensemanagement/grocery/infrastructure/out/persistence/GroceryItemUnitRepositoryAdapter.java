package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnit;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnitRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@SecondaryAdapter
@Component
@Slf4j
@RequiredArgsConstructor
@Service
public class GroceryItemUnitRepositoryAdapter implements GroceryItemUnitRepository {
    private final UnitTypeEntityRepository units;

    @Override
    public GroceryItemUnit save(GroceryItemUnit groceryItemUnit) {
        log.info("GroceryItemUnitRepositoryAdapter|save:: groceryItemUnit: {}", groceryItemUnit);
        var entity =  UnitTypeEntity.fromDomain(groceryItemUnit);
        log.info("GroceryItemUnitRepositoryAdapter|save:: converted to entity: {}", entity);
        entity = units.save(entity);
        return entity.toDomain();
    }

    @Override
    public Collection<GroceryItemUnit> all() {
        log.info("GroceryItemUnitRepositoryAdapter|all:: fetching all grocery item units");
        var result = units.findAll().stream().map(UnitTypeEntity::toDomain).toList();
        log.info("GroceryItemUnitRepositoryAdapter|all:: fetched all grocery item units: {}", result);
        return result;
    }
}

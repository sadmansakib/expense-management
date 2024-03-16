package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;

@Service
@RequiredArgsConstructor
@Slf4j
@SecondaryPort
public class GroceryItemUnitCreator {
    private final GroceryItemUnitRepository units;

    public GroceryItemUnit create(GroceryItemUnitToCreate unitToCreate) {
        log.info("GroceryItemUnitCreator|create:: unitToCreate: {}", unitToCreate);
        var domain = unitToCreate.create();
        log.info("GroceryItemUnitCreator|create:: created domain: {}", domain);
        domain = units.save(domain);
        log.info("GroceryItemUnitCreator|create:: saved domain: {}", domain);
        return domain;
    }

    public record GroceryItemUnitToCreate(String name) {
        public GroceryItemUnit create() {
            return GroceryItemUnit.builder()
                    .name(new Name(name))
                    .build();
        }
    }
}

package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.Builder;
import org.jmolecules.ddd.types.AggregateRoot;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;
import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

@Builder
public record GroceryItemUnit(Id id, Name name) implements AggregateRoot<GroceryItemUnit,Id> {
    public GroceryItemUnit {
        Assert.notNull("name", name);
    }

    @Override
    public Id getId() {
        return id;
    }
}

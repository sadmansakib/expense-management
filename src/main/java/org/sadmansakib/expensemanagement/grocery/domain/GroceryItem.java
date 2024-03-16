package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.Builder;
import org.jmolecules.ddd.types.AggregateRoot;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;
import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

import java.util.Optional;

@Builder
public record GroceryItem(Id id, Name name, Quantity quantity,
                          Optional<Amount> estimatedCost, Optional<Amount> systemEstimatedCost)
        implements AggregateRoot<GroceryItem, Id> {

    public GroceryItem {
        Assert.notNull("name", name);
        Assert.notNull("quantity", quantity);
    }

    @Override
    public Id getId() {
        return id;
    }

    public record Quantity(Double quantity) {
        public Quantity {
            Assert.field("quantity", quantity)
                    .min(0.1);
        }

        public Double get() {
            return quantity;
        }
    }
}

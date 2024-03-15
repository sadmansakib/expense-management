package org.sadmansakib.expensemanagement.category.domain;

import lombok.Builder;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.ValueObject;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

@Builder
public record Category(Id id,
                       CategoryName name,
                       CategoryDescription description,
                       Amount allocated,
                       Amount spent, Id budgetId) implements AggregateRoot<Category, Id> {

    public Category {
        Assert.notNull("name", name);
        Assert.notNull("description", description);
        Assert.field("allocated", allocated.get())
                .min(1.0);
        Assert.notNull("budgetId", budgetId);
    }

    @Override
    public Id getId() {
        return id;
    }

    public Category addSpent(Amount amount) {
        return Category.builder()
                .id(id)
                .name(name)
                .description(description)
                .allocated(allocated)
                .spent(spent.add(amount))
                .budgetId(budgetId)
                .build();
    }

    public static Category toCategory(Long id, String name, String description, Double allocated,
                                      Double spent, Long budgetId) {
        return Category.builder()
                .description(new CategoryDescription(description))
                .id(new Id(id))
                .name(new CategoryName(name))
                .allocated(new Amount(allocated))
                .spent(new Amount(spent))
                .budgetId(new Id(budgetId))
                .build();
    }

    public record CategoryName(String name) implements ValueObject {
        public String get() {
            return name;
        }
    }

    public record CategoryDescription(String description) implements ValueObject {
        public String get() {
            return description;
        }
    }
}

package org.sadmansakib.expensemanagement.category.domain;

import lombok.Builder;
import org.jmolecules.ddd.types.AggregateRoot;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@Builder
public record Category(Id id,
                       CategoryName name,
                       CategoryDescription description,
                       Amount allocated,
                       Amount spent, Id budgetId) implements AggregateRoot<Category, Id> {

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

    public static Category toCategory(Long id, String name, String description, Double totalAllocatedAmount,
                                      Double totalSpentAmount, Long budgetId) {
        return Category.builder()
                .description(new CategoryDescription(description))
                .id(new Id(id))
                .name(new CategoryName(name))
                .allocated(new Amount(totalAllocatedAmount))
                .spent(new Amount(totalSpentAmount))
                .budgetId(new Id(budgetId))
                .build();
    }

    public record CategoryName(String name) {
        public String get() {
            return name;
        }
    }

    public record CategoryDescription(String description) {
        public String get() {
            return description;
        }
    }
}

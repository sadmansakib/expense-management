package org.sadmansakib.expensemanagement.budget.domain;


import lombok.*;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@Builder
public record Budget(Id id, Amount allocated, Amount spent, Month month,
                     Year year) implements AggregateRoot<Budget, Id> {
    @Override
    public Id getId() {
        return id;
    }

    public static Budget toBudget(Long id, Double totalAllocatedAmount,
                                  Double totalSpentAmount, String month, Integer year) {
        return Budget.builder()
                .id(new Id(id))
                .allocated(new Amount(totalAllocatedAmount))
                .spent(new Amount(totalSpentAmount))
                .month(new Month(month))
                .year(new Year(year))
                .build();
    }

    public Budget addSpent(Amount amount) {
        return Budget.builder()
                .id(id)
                .allocated(allocated)
                .spent(spent.add(amount))
                .month(month)
                .year(year)
                .build();
    }

    public record BudgetId(Long id) implements Identifier {
        public Long get() {
            return id;
        }
    }


    public record Month(String month) implements ValueObject {
        public String get() {
            return month;
        }
    }

    public record Year(Integer year) implements ValueObject {
        public Integer get() {
            return year;
        }
    }
}

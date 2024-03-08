package org.sadmansakib.expensemanagement.budget.domain;


import lombok.*;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

@Builder
public record Budget(BudgetId id, Amount allocated, Amount spent, Month month,
                     Year year) implements AggregateRoot<Budget, Budget.BudgetId> {
    @Override
    public BudgetId getId() {
        return id;
    }

    public static Budget toBudget(Long id, Double totalAllocatedAmount,
                                  Double totalSpentAmount, String month, Integer year) {
        return Budget.builder()
                .id(new BudgetId(id))
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

    public record Amount(Double amount) implements ValueObject {
        public Double get() {
            return amount;
        }

        public static Amount zero() {
            return new Amount(0.0);
        }

        public Amount add(Amount amount) {
            return new Amount(this.amount + amount.amount);
        }

        public Amount subtract(Amount amount) {
            return new Amount(this.amount - amount.amount);
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

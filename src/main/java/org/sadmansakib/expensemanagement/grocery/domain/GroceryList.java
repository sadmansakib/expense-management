package org.sadmansakib.expensemanagement.grocery.domain;

import lombok.Builder;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.ValueObject;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

import java.time.LocalDate;

@Builder
public record GroceryList(Id id, Name name, Type type,
                          Amount paid, Amount estimated,
                          Date shoppingDate) implements AggregateRoot<GroceryList, Id> {

    @Override
    public Id getId() {
        return id();
    }

    public record Name(String name) implements ValueObject {
        public Name {
            Assert.notNull("name", name);
        }

        public String get() {
            return name;
        }
    }

    public enum Type implements ValueObject {
        MONTHLY,
        WEEKLY,
        URGENT
    }

    public record Date(LocalDate date) implements ValueObject {
        public Date {
            Assert.notNull("date", date);
        }

        public LocalDate get() {
            return date;
        }
    }
}

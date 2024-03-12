package org.sadmansakib.expensemanagement.expense.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.ValueObject;
import org.sadmansakib.expensemanagement.category.domain.CategoryExpenseAdded;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.UnaryOperator;

@Builder
@Getter
@ToString
public class Expense extends AbstractAggregateRoot<Expense> implements AggregateRoot<Expense, Id> {
    private final Id id;
    private final Description description;
    private final Amount amount;
    private final Date date;
    private final Id categoryId;

    public static Expense toExpense(Long id, String description, Double amount, LocalDate date, Long category) {
        return Expense.builder()
                .id(new Id(id))
                .description(new Description(description))
                .amount(new Amount(amount))
                .date(new Date(date))
                .categoryId(new Id(category))
                .build();
    }

    Expense added() {
        registerEvent(new CategoryExpenseAdded(id, amount));
        return this;
    }

    Expense then(UnaryOperator<Expense> operator) {
        return operator.apply(this);
    }

    public record Description(String value) implements ValueObject {
        public Description {
            if (Objects.isNull(value) || value.isBlank()) {
                throw new IllegalArgumentException("Description cannot be empty");
            }
        }

        public String get() {
            return value;
        }
    }

    public record Date(LocalDate value) implements ValueObject {
        public Date {
            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("Date cannot be empty");
            }
        }

        public LocalDate get() {
            return value;
        }
    }
}

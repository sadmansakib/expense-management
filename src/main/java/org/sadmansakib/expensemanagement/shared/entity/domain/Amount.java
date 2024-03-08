package org.sadmansakib.expensemanagement.shared.entity.domain;

import org.jmolecules.ddd.types.ValueObject;

public record Amount(Double amount) implements ValueObject {
    public Double get() {
        return amount();
    }
    public static Amount zero() {
        return new Amount(0.0);
    }
    public Amount add(Amount amount) {
        return new Amount(this.amount() + amount.amount());
    }
}

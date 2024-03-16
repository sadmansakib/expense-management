package org.sadmansakib.expensemanagement.shared.entity.domain;

import org.jmolecules.ddd.types.ValueObject;
import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

public record Name(String name) implements ValueObject {
    public Name {
        Assert.notNull("name", name);
    }

    public String get() {
        return name;
    }
}

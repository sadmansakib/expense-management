package org.sadmansakib.expensemanagement.shared.entity.domain;

import org.jmolecules.ddd.types.Identifier;

public record Id(Long id) implements Identifier {
    public Long get() {
        return id();
    }
}

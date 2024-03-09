package org.sadmansakib.expensemanagement.budget.domain;

import java.util.Collection;

public record Budgets(Collection<Budget> budgets) {
    public Budgets {
        if (budgets == null) {
            throw new IllegalArgumentException("Budgets cannot be null");
        }
    }

    public Collection<Budget> get(){
        return budgets;
    }
}

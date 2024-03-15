package org.sadmansakib.expensemanagement.budget.domain;

import org.sadmansakib.expensemanagement.shared.error.domain.Assert;

import java.util.Collection;

public record Budgets(Collection<Budget> budgets) {
    public Budgets {
        Assert.notNull("budgets", budgets);
    }

    public Collection<Budget> get(){
        return budgets;
    }
}

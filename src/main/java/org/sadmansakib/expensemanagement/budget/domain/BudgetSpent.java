package org.sadmansakib.expensemanagement.budget.domain;

import org.jmolecules.event.types.DomainEvent;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

public record BudgetSpent(Id budgetId, Amount spentAmount) implements DomainEvent {
}

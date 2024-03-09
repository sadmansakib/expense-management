package org.sadmansakib.expensemanagement.category.domain;

import org.jmolecules.event.annotation.Externalized;
import org.jmolecules.event.types.DomainEvent;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@Externalized("expensemanagement.category")
public record ExpenseAddedInCategoryEvent(Id categoryId, Amount spent) implements DomainEvent {
}

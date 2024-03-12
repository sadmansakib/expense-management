package org.sadmansakib.expensemanagement.expense.infrastructure.out.events;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.category.domain.CategoryExpenseAdded;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@SecondaryAdapter
@Service
public class ExpenseApplicationEventPublisher implements ExpenseEventPublisher {
    private final ApplicationEventPublisher publisher;
    @Override
    public void expenseAdded(CategoryExpenseAdded event) {
        publisher.publishEvent(event);
    }
}

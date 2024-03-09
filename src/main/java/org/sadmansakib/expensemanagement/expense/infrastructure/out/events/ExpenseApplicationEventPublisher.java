package org.sadmansakib.expensemanagement.expense.infrastructure.out.events;

import lombok.RequiredArgsConstructor;
import org.sadmansakib.expensemanagement.category.domain.ExpenseAddedInCategoryEvent;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpenseApplicationEventPublisher implements ExpenseEventPublisher {
    private final ApplicationEventPublisher publisher;
    @Override
    public void expenseAdded(ExpenseAddedInCategoryEvent event) {
        publisher.publishEvent(event);
    }
}

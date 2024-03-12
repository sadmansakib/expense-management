package org.sadmansakib.expensemanagement.category.infrastructure.out.events;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.budget.domain.BudgetSpent;
import org.sadmansakib.expensemanagement.category.domain.CategoryEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Service
@SecondaryAdapter
@RequiredArgsConstructor
public class CategoryApplicationEventPublisher implements CategoryEventPublisher {
    private final ApplicationEventPublisher publisher;

    @Override
    public void updateBudgetSpent(BudgetSpent event) {
        publisher.publishEvent(event);
    }
}
